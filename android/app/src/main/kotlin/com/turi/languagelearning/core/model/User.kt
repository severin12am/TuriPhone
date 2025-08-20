package com.turi.languagelearning.core.model

/**
 * Clean user model for native app
 */
data class User(
    val id: String,
    val email: String,
    val displayName: String?,
    val preferredLanguage: Language = Language.ENGLISH,
    val nativeLanguage: Language = Language.ENGLISH,
    val createdAt: Long = 0L,
    val lastActiveAt: Long = 0L
)

/**
 * User learning progress
 */
data class LearningProgress(
    val userId: String,
    val language: Language,
    val conversationsCompleted: Int = 0,
    val wordsLearned: Int = 0,
    val timeSpentMinutes: Int = 0,
    val currentLevel: Int = 1,
    val experiencePoints: Int = 0,
    val lastSessionAt: Long = 0L
)

/**
 * User session data
 */
data class UserSession(
    val user: User,
    val isAuthenticated: Boolean,
    val accessToken: String?,
    val refreshToken: String?,
    val expiresAt: Long?
)