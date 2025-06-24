import { supabase } from './supabase';
import { logger } from './logger';
import type { User } from '../types';
import type { SupportedLanguage } from '../constants/translations';
import { useStore } from '../store';
import { syncWordProgress, trackCompletedDialogue as progressTrackCompletedDialogue } from './progress';
import { clearSecurityCaches, validateAndSanitizeUserInput, SecurityError } from './security';

const LOCAL_STORAGE_ANONYMOUS_USER_KEY = 'turi_anonymous_user';
const LOCAL_STORAGE_USER_KEY = 'turi_user';

// Check if we can use local storage as a backup for non-registered users
const canUseLocalStorage = typeof window !== 'undefined' && window.localStorage;

// Helper function to check if user is authenticated with valid session
export const isUserAuthenticated = async (): Promise<boolean> => {
  try {
    const { data: { session }, error } = await supabase.auth.getSession();
    if (error) {
      logger.error('Error checking authentication', { error });
      return false;
    }
    return !!session?.user;
  } catch (error) {
    logger.error('Error checking authentication', { error });
    return false;
  }
};

// Get current authenticated user
export const getCurrentUser = async (): Promise<User | null> => {
  try {
    const { data: { user }, error } = await supabase.auth.getUser();
    if (error || !user) {
      return null;
    }

    // Fetch user profile
    const { data: userProfile, error: profileError } = await supabase
      .from('users')
      .select('*')
      .eq('id', user.id)
      .single();

    if (profileError) {
      logger.error('Error fetching user profile', { error: profileError });
      return null;
    }

    return userProfile as User;
  } catch (error) {
    logger.error('Error getting current user', { error });
    return null;
  }
};

/**
 * Centralized function to create language_levels record with duplicate prevention
 */
const createLanguageLevel = async (userId: string, targetLanguage: string, motherLanguage: string) => {
  try {
    // Double-check if record already exists to prevent duplicates
    const { data: existingLevel, error: checkError } = await supabase
      .from('language_levels')
      .select('*')
      .eq('user_id', userId)
      .eq('target_language', targetLanguage)
      .maybeSingle();
    
    if (existingLevel) {
      logger.info('Language level already exists, returning existing record', { userId, targetLanguage });
      return existingLevel;
    }
    
    if (checkError && checkError.code !== 'PGRST116') {
      logger.error('Error checking for existing language level', { error: checkError });
      throw checkError;
    }
    
    // Get word count for dialogue 1 - use default if query fails
    let wordCount = 7; // Default word count for dialogue 1
    try {
      const { data: words, error: wordsError } = await supabase
        .from('words_quiz')
        .select('*')
        .eq('dialogue_id', 1);
        
      if (!wordsError && words && words.length > 0) {
        wordCount = words.length;
      }
    } catch (error) {
      logger.warn('Could not fetch word count from words_quiz, using default', { error });
    }
    
    // Create the record
    const { data, error } = await supabase
      .from('language_levels')
      .insert([{
        user_id: userId,
        target_language: targetLanguage,
        mother_language: motherLanguage,
        level: 1,
        word_progress: wordCount,
        dialogue_number: 1
      }])
      .select()
      .single();
      
    if (error) {
      // Handle duplicate key errors gracefully
      if (error.code === '23505' || error.message?.includes('duplicate key')) {
        logger.warn('Duplicate key detected, fetching existing record', { error });
        
        // Fetch the existing record
        const { data: existingRecord, error: fetchError } = await supabase
          .from('language_levels')
          .select('*')
          .eq('user_id', userId)
          .eq('target_language', targetLanguage)
          .single();
          
        if (existingRecord) {
          return existingRecord;
        }
        
        if (fetchError) {
          logger.error('Error fetching existing record after duplicate', { error: fetchError });
          throw fetchError;
        }
      }
      
      // Handle language constraint violation - fallback to 'ru'
      if (error.code === '23514' && error.message?.includes('language_levels_language_check')) {
        logger.warn('Language constraint violation, falling back to ru', { 
          originalLanguage: targetLanguage, 
          error: error.message 
        });
        
        // Try again with 'ru' as target language
        const { data: fallbackData, error: fallbackError } = await supabase
          .from('language_levels')
          .insert([{
            user_id: userId,
            target_language: 'ru',
            mother_language: motherLanguage,
            level: 1,
            word_progress: wordCount,
            dialogue_number: 1
          }])
          .select()
          .single();
          
        if (fallbackError) {
          logger.error('Error creating language level with fallback', { error: fallbackError });
          throw fallbackError;
        }
        
        logger.info('Language level created with fallback language', { 
          userId, 
          originalLanguage: targetLanguage,
          fallbackLanguage: 'ru',
          wordProgress: wordCount 
        });
        return fallbackData;
      }
      
      logger.error('Error creating language level', { error });
      throw error;
    }
    
    logger.info('Language level created successfully', { 
      userId, 
      targetLanguage, 
      wordProgress: wordCount 
    });
    return data;
  } catch (error) {
    logger.error('Error in createLanguageLevel', { error });
    throw error;
  }
};

export const signUp = async (email: string, password: string, motherLanguage: string = 'en', targetLanguage: string = 'ru'): Promise<User> => {
  try {
    // Validate and sanitize input
    if (!email || typeof email !== 'string' || !email.includes('@')) {
      throw new SecurityError('Invalid email format', 'INVALID_EMAIL');
    }
    
    if (!password || typeof password !== 'string' || password.length < 6) {
      throw new SecurityError('Password must be at least 6 characters', 'INVALID_PASSWORD');
    }
    
    const sanitizedEmail = email.toLowerCase().trim();
    
    // Sign up with Supabase Auth
    const { data: authData, error: authError } = await supabase.auth.signUp({
      email: sanitizedEmail,
      password,
    });

    if (authError) {
      logger.error('Supabase auth signup error', { error: authError });
      throw new Error(authError.message);
    }

    if (!authData.user) {
      throw new Error('No user returned from signup');
    }

    // Create user profile in our users table - only use fields that exist
    const userProfile = {
      id: authData.user.id,
      email: sanitizedEmail,
      password: '', // Don't store password in our table
      mother_language: motherLanguage,
      target_language: targetLanguage,
      total_minutes: 0
    };

    const { data: userData, error: userError } = await supabase
      .from('users')
      .insert([userProfile])
      .select()
      .single();

    if (userError) {
      logger.error('Error creating user profile', { error: userError });
      throw new Error('Failed to create user profile');
    }

    // Create initial language_levels record immediately after user creation
    try {
      await createLanguageLevel(authData.user.id, targetLanguage, motherLanguage);
      logger.info('Initial language level created for new user', { userId: authData.user.id });
    } catch (levelError) {
      logger.error('Error creating initial language level', { error: levelError });
      // Don't throw here - user creation succeeded, language level can be created later
    }

    logger.info('User signed up successfully', { userId: authData.user.id });
    return userData;
  } catch (error) {
    if (error instanceof SecurityError) {
      logger.warn('Security validation failed in signup', { error: error.message });
      throw error;
    }
    logger.error('Signup failed', { error });
    throw error;
  }
};

export const login = async (email: string, password: string): Promise<User> => {
  try {
    // Validate and sanitize input
    if (!email || typeof email !== 'string' || !email.includes('@')) {
      throw new SecurityError('Invalid email format', 'INVALID_EMAIL');
    }
    
    if (!password || typeof password !== 'string') {
      throw new SecurityError('Invalid password', 'INVALID_PASSWORD');
    }
    
    const sanitizedEmail = email.toLowerCase().trim();
    
    // Sign in with Supabase Auth
    const { data: authData, error: authError } = await supabase.auth.signInWithPassword({
      email: sanitizedEmail,
      password,
    });

    if (authError) {
      logger.error('Supabase auth login error', { error: authError });
      throw new Error(authError.message);
    }

    if (!authData.user) {
      throw new Error('No user returned from login');
    }

    // Fetch user profile from our users table
    const { data: userData, error: userError } = await supabase
      .from('users')
      .select('*')
      .eq('id', authData.user.id)
      .single();

    if (userError) {
      logger.error('Error fetching user profile', { error: userError });
      throw new Error('Failed to fetch user profile');
    }

    logger.info('User logged in successfully', { userId: authData.user.id });
    return userData;
  } catch (error) {
    if (error instanceof SecurityError) {
      logger.warn('Security validation failed in login', { error: error.message });
      throw error;
    }
    logger.error('Login failed', { error });
    throw error;
  }
};

export const logout = async (): Promise<void> => {
  try {
    // Get current user before logout for cache clearing
    const { data: { user } } = await supabase.auth.getUser();
    const userId = user?.id;
    
    const { error } = await supabase.auth.signOut();
    if (error) {
      logger.error('Logout error', { error });
      throw new Error(error.message);
    }
    
    // Clear localStorage
    localStorage.removeItem('turi_user');
    
    // Clear security caches
    if (userId) {
      clearSecurityCaches(userId);
    } else {
      clearSecurityCaches(); // Clear all caches if no specific user
    }
    
    logger.info('User logged out successfully');
  } catch (error) {
    logger.error('Logout failed', { error });
    throw error;
  }
};

// Functions for anonymous users
export const saveAnonymousProgress = (dialogueId: number, characterId: number, score: number) => {
  if (!canUseLocalStorage) return false;
  
  try {
    // Get existing anonymous progress or create a new one
    const savedProgress = localStorage.getItem(LOCAL_STORAGE_ANONYMOUS_USER_KEY);
    const progress = savedProgress ? JSON.parse(savedProgress) : {
      dialogues: [],
      wordProgress: 0
    };
    
    // Add or update dialogue progress
    const existingDialogueIndex = progress.dialogues.findIndex(
      (d: any) => d.dialogueId === dialogueId && d.characterId === characterId
    );
    
    if (existingDialogueIndex > -1) {
      // Update existing entry with higher score if applicable
      if (score > progress.dialogues[existingDialogueIndex].score) {
        progress.dialogues[existingDialogueIndex].score = score;
      }
    } else {
      // Add new entry
      progress.dialogues.push({
        dialogueId,
        characterId,
        score,
        completed: true,
        completedAt: new Date().toISOString()
      });
    }
    
    // Update word progress - use the highest dialogue ID as a simple proxy
    const highestDialogueId = Math.max(
      progress.wordProgress || 0,
      ...progress.dialogues.map((d: any) => d.dialogueId)
    );
    progress.wordProgress = highestDialogueId;
    
    // Save back to local storage
    localStorage.setItem(LOCAL_STORAGE_ANONYMOUS_USER_KEY, JSON.stringify(progress));
    logger.info('Anonymous progress saved', { dialogueId, characterId, score });
    
    return true;
  } catch (error) {
    logger.error('Error saving anonymous progress', { error });
    return false;
  }
};

// Get anonymous progress from localStorage
export const getAnonymousProgress = () => {
  try {
    if (!canUseLocalStorage) {
      logger.warn('localStorage not available for getting anonymous progress');
      return null;
    }
    
    // Get progress data from localStorage
    const anonymousProgress = localStorage.getItem('turi_anonymous_progress');
    if (!anonymousProgress) {
      return null;
    }
    
    // Parse stored data
    const progressData = JSON.parse(anonymousProgress);
    logger.info('Retrieved anonymous progress', { progressData });
    
    return progressData;
  } catch (error) {
    logger.error('Error getting anonymous progress', { error });
    return null;
  }
};

export const transferAnonymousProgressToUser = async (userId: string) => {
  if (!canUseLocalStorage) return;
  
  try {
    const anonymousProgress = getAnonymousProgress();
    if (!anonymousProgress || !anonymousProgress.dialogues) return;
    
    // Transfer dialogue completions
    for (const dialogue of anonymousProgress.dialogues) {
      await progressTrackCompletedDialogue(
        userId,
        dialogue.characterId,
        dialogue.dialogueId,
        dialogue.score
      );
    }
    
    // Word progress is already handled by the dialogue completions above
    // No need for separate word progress transfer
    
    // Clear anonymous progress
    localStorage.removeItem(LOCAL_STORAGE_ANONYMOUS_USER_KEY);
    
    logger.info('Anonymous progress transferred to user', { userId });
  } catch (error) {
    logger.error('Error transferring anonymous progress', { error });
  }
};

// Initialize language level for a new user
export const initializeLanguageLevel = async (userId: string, language: string, motherLanguage: string) => {
  try {
    console.log('💬 INITIALIZE LANGUAGE LEVEL FUNCTION CALLED', { userId, language, motherLanguage });
    logger.info('Initializing language level', { userId, language, motherLanguage });
    
    // Use the centralized createLanguageLevel function
    return await createLanguageLevel(userId, language, motherLanguage);
  } catch (error) {
    console.error('💬 ERROR in initializeLanguageLevel:', error);
    logger.error('Error initializing language level', { error });
    throw error;
  }
};

// Get user's language level
export const getLanguageLevel = async (userId: string, language: string) => {
  try {
    const { data, error } = await supabase
      .from('language_levels')
      .select('*')
      .eq('user_id', userId)
      .eq('target_language', language)
      .single();
      
    if (error) {
      if (error.code === 'PGRST116') { // No rows returned
        // Initialize level if not found using centralized function
        const result = await createLanguageLevel(userId, language, 'en');
        return result;
      }
      logger.error('Error getting language level', { error });
      throw error;
    }
    
    return data;
  } catch (error) {
    logger.error('Error getting language level', { error });
    throw error;
  }
};

// Note: updateWordProgress function removed to prevent duplicate word counting
// All word progress is now handled by trackCompletedDialogue function

// Track completed dialogue
export const trackCompletedDialogue = async (
  userId: string, 
  characterId: number, 
  dialogueId: number, 
  score: number
) => {
  console.log('💬 TRACK COMPLETED DIALOGUE FUNCTION CALLED', { userId, characterId, dialogueId, score });
  return progressTrackCompletedDialogue(userId, characterId, dialogueId, score);
};

// Get user's completed dialogues
export const getCompletedDialogues = async (userId: string) => {
  try {
    console.log('💬 GET COMPLETED DIALOGUES FUNCTION CALLED', { userId });
    
    // Define the type of dialogue progress
    interface DialogueProgress {
      user_id: string;
      dialogue_id: number;
      character_id: number;
      completed: boolean;
      score: number;
      completed_at: string;
      [key: string]: any; // For any other properties
    }
    
    // First, check the user_progress table for completed dialogues
    const { data: userProgressData, error: progressError } = await supabase
      .from('user_progress')
      .select('*')
      .eq('user_id', userId)
      .eq('completed', true);
    
    if (progressError) {
      console.error('💬 ERROR fetching from user_progress:', progressError);
      logger.error('Error fetching from user_progress', { error: progressError });
      // Continue to try the language_levels table as fallback
    }
    
    // Initialize completedDialogues with data from user_progress if available
    let completedDialogues: DialogueProgress[] = [];
    if (userProgressData && userProgressData.length > 0) {
      console.log('💬 Found completed dialogues in user_progress:', userProgressData.length);
      completedDialogues = [...userProgressData] as DialogueProgress[];
    }
    
    // Get the user's language level as a fallback or supplement
    const { data: languageLevel, error } = await supabase
      .from('language_levels')
      .select('*')
      .eq('user_id', userId)
      .single();
      
    if (error) {
      console.error('💬 ERROR getting language level for dialogue progress:', error);
      logger.error('Error getting language level for dialogue progress', { error });
      
      // If we have user_progress data, return that even if language_levels fails
      if (completedDialogues.length > 0) {
        console.log('💬 Returning completed dialogues from user_progress only:', 
          completedDialogues.map(d => d.dialogue_id));
        return completedDialogues;
      }
      return [];
    }
    
    console.log('💬 Found language level:', languageLevel);
    
    // Use dialogue_number to determine completed dialogues if not already in the list
    if (languageLevel && languageLevel.dialogue_number > 0) {
      // Create a list of completed dialogues based on the dialogue_number value
      console.log('💬 Using dialogue_number to supplement completed dialogues:', languageLevel.dialogue_number);
      
      // Get a list of dialogue IDs we already have from user_progress
      const existingDialogueIds = new Set(completedDialogues.map(d => d.dialogue_id));
      
      for (let i = 1; i <= languageLevel.dialogue_number; i++) {
        // Only add if not already in the list from user_progress
        if (!existingDialogueIds.has(i)) {
          completedDialogues.push({
            user_id: userId,
            dialogue_id: i,
            character_id: 1, // Assuming character_id 1 for all dialogues
            completed: true,
            score: 100, // Default score
            completed_at: new Date().toISOString()
          });
        }
      }
    } else {
      console.log('💬 No dialogue_number found in language level');
    }
    
    // Also check local storage for any completions
    if (canUseLocalStorage) {
      console.log('💬 Checking localStorage for dialogue completions');
      
      // Get existing dialogue IDs
      const existingDialogueIds = new Set(completedDialogues.map(d => d.dialogue_id));
      
      for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (key && key.startsWith(`dialogue_completion_${userId}`)) {
          const [_, userId, characterId, dialogueId] = key.split('_');
          const data = JSON.parse(localStorage.getItem(key) || '{}');
          
          console.log('💬 Found localStorage completion:', { userId, characterId, dialogueId, data });
          
          // Add if not already in the list
          if (!existingDialogueIds.has(parseInt(dialogueId))) {
            completedDialogues.push({
              user_id: userId,
              dialogue_id: parseInt(dialogueId),
              character_id: parseInt(characterId),
              completed: true,
              score: data.score || 100,
              completed_at: data.completed_at || new Date().toISOString()
            });
          }
        }
      }
    }
    
    console.log('💬 Total completed dialogues:', completedDialogues.length);
    console.log('💬 Completed dialogue IDs:', completedDialogues.map(d => d.dialogue_id));
    
    return completedDialogues;
  } catch (error) {
    console.error('💬 ERROR getting completed dialogues:', error);
    logger.error('Error getting completed dialogues', { error });
    return [];
  }
};

// Check and update user's progress based on completed dialogues
export const checkAndUpdateUserProgress = async (userId: string) => {
  try {
    console.log('💬 CHECK AND UPDATE USER PROGRESS FUNCTION CALLED', { userId });
    
    if (!userId) {
      logger.warn('Cannot update progress for empty user ID');
      return null;
    }
    
    const { targetLanguage } = useStore.getState();
    if (!targetLanguage) {
      logger.warn('Cannot update progress without target language');
      return null;
    }
    
    // Get completed dialogues to determine highest dialogue ID completed
    const completedDialogues = await getCompletedDialogues(userId);
    if (!completedDialogues || completedDialogues.length === 0) {
      console.log('💬 No completed dialogues found for user');
      logger.info('No completed dialogues found for user', { userId });
      return null;
    }
    
    // Find the highest dialogue ID completed
    const highestDialogueId = Math.max(...completedDialogues.map(d => d.dialogue_id));
    console.log('💬 Highest dialogue ID completed:', highestDialogueId);
    
    // Get current language level
    const { data: languageLevel, error } = await supabase
      .from('language_levels')
      .select('*')
      .eq('user_id', userId)
      .eq('target_language', targetLanguage)
      .single();
      
    if (error) {
      if (error.code === 'PGRST116') {
        console.log('💬 No language level entry exists, creating one');
        // No language level entry exists, create one with the highest dialogue
        // Use trackCompletedDialogue which calculates total progress correctly
        await progressTrackCompletedDialogue(userId, 1, highestDialogueId, 100);
        
        // Fetch the newly created language level
        const { data: newLevel, error: newLevelError } = await supabase
          .from('language_levels')
          .select('*')
          .eq('user_id', userId)
          .eq('target_language', targetLanguage)
          .single();
          
        return newLevelError ? null : newLevel;
      }
      
      console.error('💬 ERROR fetching language level:', error);
      logger.error('Error fetching language level', { error });
      return null;
    }
    
    console.log('💬 Current language level data:', languageLevel);
    
    // Calculate what level the user should be at
    // Level 1: Dialogues 1-5
    // Level 2: Dialogues 6-10
    // And so on...
    const correctLevel = Math.floor((highestDialogueId - 1) / 5) + 1;
    console.log('💬 Calculated level:', correctLevel, `based on formula: Math.floor((${highestDialogueId} - 1) / 5) + 1`);
    
    // Count words for completed dialogues
    const { data: wordCounts, error: wordCountError } = await supabase
      .from('words_quiz')
      .select('dialogue_id')
      .lte('dialogue_id', highestDialogueId);
    
    let correctWordProgress = 0;
    
    if (!wordCountError && wordCounts) {
      correctWordProgress = wordCounts.length;
      console.log('💬 Calculated correct word progress:', correctWordProgress, `based on ${wordCounts.length} words in dialogues 1-${highestDialogueId}`);
    } else {
      console.error('💬 ERROR counting words:', wordCountError);
    }
    
    // Check if update is needed
    const needsUpdate = 
      languageLevel.level !== correctLevel || 
      languageLevel.word_progress !== correctWordProgress ||
      languageLevel.dialogue_number !== highestDialogueId;
    
    console.log('💬 Needs update?', needsUpdate, {
      currentLevel: languageLevel.level,
      correctLevel,
      currentWordProgress: languageLevel.word_progress,
      correctWordProgress,
      currentDialogueNumber: languageLevel.dialogue_number,
      highestDialogueId
    });
    
    if (needsUpdate) {
      // Update to correct values
      const { data, error: updateError } = await supabase
        .from('language_levels')
        .update({ 
          level: correctLevel,
          word_progress: correctWordProgress,
          dialogue_number: highestDialogueId
        })
        .eq('user_id', userId)
        .eq('target_language', targetLanguage)
        .select();
        
      if (updateError) {
        console.error('💬 ERROR updating user progress:', updateError);
        logger.error('Error updating user progress', { updateError });
        return languageLevel;
      }
      
      console.log('💬 Successfully updated user progress:', data?.[0]);
      
      logger.info('User progress auto-updated', { 
        userId, 
        previousLevel: languageLevel.level,
        newLevel: correctLevel, 
        previousWordProgress: languageLevel.word_progress,
        newWordProgress: correctWordProgress 
      });
      
      return data[0];
    }
    
    return languageLevel;
  } catch (error) {
    console.error('💬 ERROR in checkAndUpdateUserProgress:', error);
    logger.error('Error in checkAndUpdateUserProgress', { error });
    return null;
  }
};

// Session validation utility
export const validateSession = async (): Promise<User | null> => {
  try {
    const { data: { session }, error } = await supabase.auth.getSession();
    
    if (error) {
      logger.error('Error validating session', { error });
      return null;
    }
    
    if (!session?.user) {
      logger.info('No active session found');
      return null;
    }
    
    // Double-check that the user is still valid
    const { data: { user: currentUser }, error: userError } = await supabase.auth.getUser();
    if (userError || !currentUser || currentUser.id !== session.user.id) {
      logger.warn('Session user validation failed');
      return null;
    }
    
    // Fetch user profile
    const { data: userData, error: userError2 } = await supabase
      .from('users')
      .select('*')
      .eq('id', session.user.id)
      .single();
      
    if (userError2) {
      logger.error('Error fetching user profile during session validation', { error: userError2 });
      return null;
    }
    
    logger.info('Session validated successfully', { userId: session.user.id });
    return userData;
  } catch (error) {
    logger.error('Session validation failed', { error });
    return null;
  }
};

/**
 * Debug session state - useful for troubleshooting login issues
 */
export const debugSessionState = async (): Promise<void> => {
  try {
    console.group('🔍 Session Debug Information');
    
    // Check Supabase session
    const { data: { session }, error: sessionError } = await supabase.auth.getSession();
    console.log('Supabase Session:', {
      hasSession: !!session,
      hasUser: !!session?.user,
      userId: session?.user?.id,
      email: session?.user?.email,
      expiresAt: session?.expires_at,
      error: sessionError
    });
    
    // Check current user
    const { data: { user }, error: userError } = await supabase.auth.getUser();
    console.log('Current User:', {
      hasUser: !!user,
      userId: user?.id,
      email: user?.email,
      error: userError
    });
    
    // Check localStorage
    const savedUser = localStorage.getItem('turi_user');
    const authToken = localStorage.getItem('turi-auth-token');
    console.log('Local Storage:', {
      hasSavedUser: !!savedUser,
      hasAuthToken: !!authToken,
      savedUserEmail: savedUser ? JSON.parse(savedUser)?.email : null
    });
    
    // Check if session is expired
    if (session?.expires_at) {
      const expiresAt = new Date(session.expires_at * 1000);
      const now = new Date();
      const isExpired = expiresAt < now;
      const timeUntilExpiry = expiresAt.getTime() - now.getTime();
      
      console.log('Session Timing:', {
        expiresAt: expiresAt.toISOString(),
        isExpired,
        timeUntilExpiryMs: timeUntilExpiry,
        timeUntilExpiryMinutes: Math.round(timeUntilExpiry / 60000)
      });
    }
    
    console.groupEnd();
  } catch (error) {
    console.error('Error debugging session state:', error);
  }
};

/**
 * Force refresh the current session
 */
export const refreshSession = async (): Promise<boolean> => {
  try {
    logger.info('Attempting to refresh session');
    const { data, error } = await supabase.auth.refreshSession();
    
    if (error) {
      logger.error('Failed to refresh session', { error });
      return false;
    }
    
    if (data.session) {
      logger.info('Session refreshed successfully');
      return true;
    }
    
    return false;
  } catch (error) {
    logger.error('Error refreshing session', { error });
    return false;
  }
};

/**
 * Create an anonymous session for users who want to use the app without signing up
 * This creates a temporary user record that can be used with RLS
 */
export const createAnonymousSession = async (userData: Omit<User, 'id'>): Promise<User> => {
  try {
    // For anonymous users, we'll create a user record with a generated ID
    // This allows them to work with RLS policies
    const anonymousId = `anon_${Date.now()}_${Math.random().toString(36).substr(2, 9)}`;
    
    const { data: createdUser, error } = await supabase
      .from('users')
      .insert([{ ...userData, id: anonymousId }])
      .select()
      .single();
      
    if (error) {
      logger.error('Error creating anonymous user', { error });
      throw new Error('Failed to create anonymous user');
    }
    
    logger.info('Anonymous user created', { userId: anonymousId });
    return createdUser;
  } catch (error) {
    logger.error('Anonymous session creation failed', { error });
    throw error;
  }
}; 