package com.turi.languagelearning.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val generalError: String? = null,
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false
)

// @HiltViewModel // Temporarily disabled
class LoginViewModel /* @Inject constructor() */ : ViewModel() {
    
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    
    fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(
            email = email,
            emailError = null,
            generalError = null
        )
    }
    
    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(
            password = password,
            passwordError = null,
            generalError = null
        )
    }
    
    fun login() {
        if (!validateInput()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, generalError = null)
            
            try {
                // TODO: Implement actual login logic with Supabase
                // For now, simulate login
                kotlinx.coroutines.delay(1000)
                
                // Simulate successful login
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    generalError = e.message ?: "Login failed. Please try again."
                )
            }
        }
    }
    
    fun createAccount() {
        if (!validateInput()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, generalError = null)
            
            try {
                // TODO: Implement actual account creation logic with Supabase
                // For now, simulate account creation
                kotlinx.coroutines.delay(1000)
                
                // Simulate successful account creation and login
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    generalError = e.message ?: "Account creation failed. Please try again."
                )
            }
        }
    }
    
    private fun validateInput(): Boolean {
        var isValid = true
        var emailError: String? = null
        var passwordError: String? = null
        
        // Validate email
        if (_uiState.value.email.isBlank()) {
            emailError = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(_uiState.value.email).matches()) {
            emailError = "Invalid email format"
            isValid = false
        }
        
        // Validate password
        if (_uiState.value.password.isBlank()) {
            passwordError = "Password is required"
            isValid = false
        } else if (_uiState.value.password.length < 6) {
            passwordError = "Password must be at least 6 characters"
            isValid = false
        }
        
        _uiState.value = _uiState.value.copy(
            emailError = emailError,
            passwordError = passwordError
        )
        
        return isValid
    }
}