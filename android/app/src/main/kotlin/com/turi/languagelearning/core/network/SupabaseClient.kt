package com.turi.languagelearning.core.network

import com.turi.languagelearning.core.model.User
import com.turi.languagelearning.core.model.LearningProgress
import com.turi.languagelearning.core.model.UserSession
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Clean Supabase client for native Android
 * Handles authentication and data persistence
 */
@Singleton
class SupabaseClient @Inject constructor() {
    
    private val supabase = createSupabaseClient(
        supabaseUrl = "YOUR_SUPABASE_URL", // TODO: Add to BuildConfig
        supabaseKey = "YOUR_SUPABASE_ANON_KEY" // TODO: Add to BuildConfig
    ) {
        install(Auth)
        install(Postgrest)
    }
    
    // Authentication
    suspend fun signUp(email: String, password: String): Result<UserSession> {
        return try {
            val result = supabase.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            
            val user = result.user
            if (user != null) {
                val userSession = UserSession(
                    user = User(
                        id = user.id,
                        email = user.email ?: email,
                        displayName = user.userMetadata?.get("display_name") as? String
                    ),
                    isAuthenticated = true,
                    accessToken = result.session?.accessToken,
                    refreshToken = result.session?.refreshToken,
                    expiresAt = result.session?.expiresAt
                )
                Result.success(userSession)
            } else {
                Result.failure(Exception("Failed to create user"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun signIn(email: String, password: String): Result<UserSession> {
        return try {
            val result = supabase.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            
            val user = result.user
            if (user != null) {
                val userSession = UserSession(
                    user = User(
                        id = user.id,
                        email = user.email ?: email,
                        displayName = user.userMetadata?.get("display_name") as? String
                    ),
                    isAuthenticated = true,
                    accessToken = result.session?.accessToken,
                    refreshToken = result.session?.refreshToken,
                    expiresAt = result.session?.expiresAt
                )
                Result.success(userSession)
            } else {
                Result.failure(Exception("Failed to sign in"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun signOut(): Result<Unit> {
        return try {
            supabase.auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getCurrentUser(): User? {
        return try {
            val user = supabase.auth.currentUserOrNull()
            user?.let {
                User(
                    id = it.id,
                    email = it.email ?: "",
                    displayName = it.userMetadata?.get("display_name") as? String
                )
            }
        } catch (e: Exception) {
            null
        }
    }
    
    // Learning Progress
    suspend fun saveLearningProgress(progress: LearningProgress): Result<Unit> {
        return try {
            supabase.from("learning_progress").upsert(progress)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getLearningProgress(userId: String): Result<List<LearningProgress>> {
        return try {
            val progress = supabase.from("learning_progress")
                .select()
                .eq("user_id", userId)
                .decodeList<LearningProgress>()
            Result.success(progress)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // User Profile
    suspend fun updateUserProfile(user: User): Result<Unit> {
        return try {
            supabase.from("profiles").upsert(user)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getUserProfile(userId: String): Result<User?> {
        return try {
            val profile = supabase.from("profiles")
                .select()
                .eq("id", userId)
                .decodeSingleOrNull<User>()
            Result.success(profile)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}