package com.turi.languagelearning.presentation.screens.dialogue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turi.languagelearning.domain.model.Dialogue
import com.turi.languagelearning.domain.model.DialogueOption
import com.turi.languagelearning.domain.model.DialogueSession
import com.turi.languagelearning.services.TextToSpeechService
import com.turi.languagelearning.services.GeminiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DialogueUiState(
    val isLoading: Boolean = false,
    val currentDialogue: Dialogue? = null,
    val dialogueSession: DialogueSession? = null,
    val wordExplanation: String? = null,
    val error: String? = null
)

@HiltViewModel
class DialogueViewModel @Inject constructor(
    private val ttsService: TextToSpeechService,
    private val geminiService: GeminiService
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(DialogueUiState())
    val uiState: StateFlow<DialogueUiState> = _uiState.asStateFlow()
    
    fun startDialogue(characterId: String, characterName: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                // Generate initial dialogue using Gemini AI
                val initialDialogue = generateInitialDialogue(characterId, characterName)
                
                val session = DialogueSession(
                    sessionId = "session_${System.currentTimeMillis()}",
                    characterId = characterId,
                    characterName = characterName,
                    currentDialogueId = initialDialogue.id,
                    language = "spanish", // TODO: Get from user preferences
                    startTime = System.currentTimeMillis()
                )
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    currentDialogue = initialDialogue,
                    dialogueSession = session
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Failed to start dialogue: ${e.message}"
                )
            }
        }
    }
    
    fun selectDialogueOption(option: DialogueOption) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            try {
                val currentSession = _uiState.value.dialogueSession
                if (currentSession != null) {
                    // Generate next dialogue based on user's choice
                    val nextDialogue = generateNextDialogue(
                        currentSession.characterName,
                        option.text,
                        currentSession.language
                    )
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        currentDialogue = nextDialogue,
                        dialogueSession = currentSession.copy(
                            currentDialogueId = nextDialogue.id,
                            dialogueHistory = currentSession.dialogueHistory + option.id
                        )
                    )
                }
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Failed to continue dialogue: ${e.message}"
                )
            }
        }
    }
    
    fun speakCurrentDialogue() {
        val currentDialogue = _uiState.value.currentDialogue
        if (currentDialogue != null) {
            ttsService.speak(currentDialogue.phrase.text)
        }
    }
    
    fun explainWord(word: String) {
        viewModelScope.launch {
            try {
                val explanation = geminiService.explainWord(word, "spanish") // TODO: Use current language
                _uiState.value = _uiState.value.copy(wordExplanation = explanation)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = "Failed to get word explanation: ${e.message}"
                )
            }
        }
    }
    
    fun dismissWordExplanation() {
        _uiState.value = _uiState.value.copy(wordExplanation = null)
    }
    
    private suspend fun generateInitialDialogue(characterId: String, characterName: String): Dialogue {
        // Create a greeting dialogue based on character
        val greetingPrompt = """
            Create a greeting dialogue for a Spanish language learning conversation.
            Character: $characterName
            Context: This is the first interaction with this character in a language learning app.
            
            Provide:
            1. A natural Spanish greeting phrase
            2. English translation
            3. 2-3 response options for the learner
            4. Keep it beginner-friendly
        """.trimIndent()
        
        // For now, return a hardcoded example - in production, use Gemini
        return createSampleDialogue(characterId, characterName)
    }
    
    private suspend fun generateNextDialogue(
        characterName: String,
        userResponse: String,
        language: String
    ): Dialogue {
        // Generate contextual response based on user's choice
        // For now, return a sample follow-up
        return createSampleFollowUpDialogue(characterName, userResponse)
    }
    
    private fun createSampleDialogue(characterId: String, characterName: String): Dialogue {
        return Dialogue(
            id = "greeting_$characterId",
            characterName = characterName,
            phrase = com.turi.languagelearning.domain.model.Phrase(
                id = "phrase_greeting",
                text = "¡Hola! ¿Cómo estás?",
                translation = "Hello! How are you?"
            ),
            options = listOf(
                DialogueOption(
                    id = "response_good",
                    text = "¡Muy bien, gracias!",
                    translation = "Very well, thank you!"
                ),
                DialogueOption(
                    id = "response_okay",
                    text = "Bien, ¿y tú?",
                    translation = "Good, and you?"
                ),
                DialogueOption(
                    id = "response_learning",
                    text = "Estoy aprendiendo español",
                    translation = "I'm learning Spanish"
                )
            ),
            isQuestion = true,
            context = "Greeting conversation",
            learningPoints = listOf(
                "¿Cómo estás? is a common way to ask 'How are you?' in Spanish",
                "¡Hola! is the most common greeting"
            )
        )
    }
    
    private fun createSampleFollowUpDialogue(characterName: String, userResponse: String): Dialogue {
        return Dialogue(
            id = "followup_${System.currentTimeMillis()}",
            characterName = characterName,
            phrase = com.turi.languagelearning.domain.model.Phrase(
                id = "phrase_followup",
                text = "¡Excelente! Me alegra conocerte.",
                translation = "Excellent! I'm happy to meet you."
            ),
            options = listOf(
                DialogueOption(
                    id = "continue_conversation",
                    text = "Igualmente",
                    translation = "Likewise"
                ),
                DialogueOption(
                    id = "ask_question",
                    text = "¿De dónde eres?",
                    translation = "Where are you from?"
                )
            ),
            isQuestion = false,
            context = "Follow-up conversation",
            learningPoints = listOf(
                "Me alegra means 'I'm happy' or 'it makes me happy'",
                "Conocerte means 'to meet you'"
            )
        )
    }
}