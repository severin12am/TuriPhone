package com.turi.languagelearning.presentation.screens.language

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class LanguageSelectionStep {
    SelectMotherLanguage,
    SelectTargetLanguage,
    ReadyToStart
}

data class LanguageSelectionUiState(
    val selectionStep: LanguageSelectionStep = LanguageSelectionStep.SelectMotherLanguage,
    val motherLanguage: String? = null,
    val targetLanguage: String? = null,
    val isLoading: Boolean = false
)

// @HiltViewModel // Temporarily disabled
class LanguageSelectionViewModel /* @Inject constructor() */ : ViewModel() {
    
    private val _uiState = MutableStateFlow<LanguageSelectionUiState>(LanguageSelectionUiState())
    val uiState: StateFlow<LanguageSelectionUiState> = _uiState.asStateFlow()
    
    fun selectMotherLanguage(languageCode: String) {
        _uiState.value = _uiState.value.copy(
            motherLanguage = languageCode,
            selectionStep = LanguageSelectionStep.SelectTargetLanguage
        )
    }
    
    fun selectTargetLanguage(languageCode: String) {
        _uiState.value = _uiState.value.copy(
            targetLanguage = languageCode,
            selectionStep = LanguageSelectionStep.ReadyToStart
        )
    }
    
    fun goBack() {
        val currentStep = _uiState.value.selectionStep
        val newStep = when (currentStep) {
            LanguageSelectionStep.SelectTargetLanguage -> LanguageSelectionStep.SelectMotherLanguage
            LanguageSelectionStep.ReadyToStart -> LanguageSelectionStep.SelectTargetLanguage
            LanguageSelectionStep.SelectMotherLanguage -> LanguageSelectionStep.SelectMotherLanguage // Can't go back further
        }
        
        _uiState.value = _uiState.value.copy(selectionStep = newStep)
    }
}