package com.turi.languagelearning.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turi.languagelearning.data.local.dao.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class SplashNavigationDestination {
    LanguageSelection,
    Game
}

data class SplashUiState(
    val isLoading: Boolean = true,
    val loadingMessage: String = "Loading...",
    val navigationDestination: SplashNavigationDestination? = null
)

// @HiltViewModel // Temporarily disabled
class SplashViewModel /* @Inject constructor(
    private val userDao: UserDao
) */ : ViewModel() {
    // Temporary mock dependency
    private val userDao: UserDao? = null
    
    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState())
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()
    
    init {
        initializeApp()
    }
    
    private fun initializeApp() {
        viewModelScope.launch {
            try {
                // Update loading message
                _uiState.value = _uiState.value.copy(loadingMessage = "Initializing app...")
                delay(1000) // Simulate initialization time
                
                // Check if user exists and is authenticated
                _uiState.value = _uiState.value.copy(loadingMessage = "Checking user session...")
                val currentUser = userDao.getCurrentUser()
                
                delay(500) // Brief delay for UX
                
                // Navigate based on user state
                val destination = if (currentUser != null && currentUser.isAuthenticated) {
                    // User is logged in, go directly to game
                    SplashNavigationDestination.Game
                } else {
                    // No user or not authenticated, go to language selection
                    SplashNavigationDestination.LanguageSelection
                }
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    navigationDestination = destination
                )
                
            } catch (e: Exception) {
                // If anything fails, default to language selection
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    navigationDestination = SplashNavigationDestination.LanguageSelection
                )
            }
        }
    }
}