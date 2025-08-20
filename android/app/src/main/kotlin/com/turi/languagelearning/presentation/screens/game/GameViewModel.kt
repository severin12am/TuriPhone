package com.turi.languagelearning.presentation.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class GameUiState(
    val isLoading: Boolean = true,
    val isSceneReady: Boolean = false,
    val currentCharacterId: Int? = null,
    val isDialogueOpen: Boolean = false,
    val isQuizActive: Boolean = false
)

@HiltViewModel
class GameViewModel @Inject constructor(
    // Removed NativeRenderer dependency - using pure Compose approach
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
    init {
        initializeGame()
    }
    
    private fun initializeGame() {
        viewModelScope.launch {
            // Simulate scene initialization
            delay(1000) // Brief loading for UI setup
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isSceneReady = true
            )
        }
    }
    
    // Game interaction methods
    fun onCharacterInteraction(characterId: Int) {
        _uiState.value = _uiState.value.copy(
            currentCharacterId = characterId,
            isDialogueOpen = true
        )
    }
    
    fun onDialogueClose() {
        _uiState.value = _uiState.value.copy(
            currentCharacterId = null,
            isDialogueOpen = false
        )
    }
    
    fun onQuizStart() {
        _uiState.value = _uiState.value.copy(
            isQuizActive = true
        )
    }
    
    fun onQuizEnd() {
        _uiState.value = _uiState.value.copy(
            isQuizActive = false
        )
    }
}