package com.turi.languagelearning.features.conversation.domain

import com.turi.languagelearning.core.model.Language

/**
 * Clean conversation service for Gemini AI integration
 */
interface ConversationService {
    
    // Conversation Management
    suspend fun startConversation(
        characterName: String,
        language: Language,
        userLevel: Int = 1
    ): ConversationResult
    
    suspend fun continueConversation(
        conversationId: String,
        userInput: String,
        language: Language
    ): ConversationResult
    
    suspend fun endConversation(conversationId: String)
    
    // Word Explanations
    suspend fun explainWord(
        word: String,
        language: Language,
        context: String? = null
    ): WordExplanation
    
    // Grammar Help
    suspend fun explainGrammar(
        sentence: String,
        language: Language
    ): GrammarExplanation
    
    // Progress Evaluation
    suspend fun evaluateResponse(
        userResponse: String,
        expectedResponse: String,
        language: Language
    ): ResponseEvaluation
}

/**
 * Conversation models
 */
data class ConversationResult(
    val conversationId: String,
    val characterName: String,
    val characterMessage: String,
    val translation: String,
    val responseOptions: List<ResponseOption> = emptyList(),
    val learningTips: List<String> = emptyList(),
    val difficulty: Int = 1,
    val isComplete: Boolean = false
)

data class ResponseOption(
    val id: String,
    val text: String,
    val translation: String,
    val isCorrect: Boolean = true,
    val difficulty: Int = 1
)

data class WordExplanation(
    val word: String,
    val language: Language,
    val translation: String,
    val pronunciation: String,
    val partOfSpeech: String,
    val definition: String,
    val examples: List<String>,
    val grammarNotes: String? = null,
    val culturalContext: String? = null
)

data class GrammarExplanation(
    val sentence: String,
    val language: Language,
    val explanation: String,
    val grammarRules: List<String>,
    val examples: List<String>,
    val commonMistakes: List<String> = emptyList()
)

data class ResponseEvaluation(
    val userResponse: String,
    val isCorrect: Boolean,
    val accuracy: Float, // 0.0 to 1.0
    val feedback: String,
    val corrections: List<String> = emptyList(),
    val suggestions: List<String> = emptyList(),
    val grammarTips: List<String> = emptyList()
)

/**
 * Character information
 */
data class Character(
    val id: String,
    val name: String,
    val description: String,
    val personality: String,
    val background: String,
    val languages: List<Language>,
    val difficulty: Int = 1,
    val modelPath: String? = null
)