package com.turi.languagelearning.features.speech.domain

import com.turi.languagelearning.core.model.Language
import kotlinx.coroutines.flow.Flow

/**
 * Clean speech service interface for 8-language support
 * Native Android TTS and Speech Recognition
 */
interface SpeechService {
    
    // Text-to-Speech
    suspend fun speak(text: String, language: Language = Language.ENGLISH)
    suspend fun speakWithCallback(
        text: String, 
        language: Language = Language.ENGLISH,
        onStart: () -> Unit = {},
        onComplete: () -> Unit = {},
        onError: (String) -> Unit = {}
    )
    fun stopSpeaking()
    fun isSpeaking(): Boolean
    
    // Speech Recognition
    suspend fun startListening(language: Language = Language.ENGLISH): Flow<SpeechResult>
    fun stopListening()
    fun isListening(): Boolean
    
    // Language Management
    fun getSupportedTtsLanguages(): List<Language>
    fun getSupportedSpeechLanguages(): List<Language>
    fun isLanguageSupported(language: Language): Boolean
    
    // Settings
    fun setSpeechRate(rate: Float) // 0.5f to 2.0f
    fun setPitch(pitch: Float)     // 0.5f to 2.0f
    
    // Lifecycle
    fun initialize()
    fun cleanup()
}

/**
 * Speech recognition result
 */
sealed class SpeechResult {
    object Listening : SpeechResult()
    data class PartialResult(val text: String, val confidence: Float) : SpeechResult()
    data class FinalResult(val text: String, val confidence: Float) : SpeechResult()
    data class Error(val message: String, val code: Int) : SpeechResult()
    object Stopped : SpeechResult()
}

/**
 * TTS state
 */
data class TtsState(
    val isInitialized: Boolean = false,
    val isSpeaking: Boolean = false,
    val currentLanguage: Language = Language.ENGLISH,
    val supportedLanguages: List<Language> = emptyList(),
    val speechRate: Float = 1.0f,
    val pitch: Float = 1.0f,
    val error: String? = null
)

/**
 * Speech recognition state
 */
data class SpeechRecognitionState(
    val isInitialized: Boolean = false,
    val isListening: Boolean = false,
    val currentLanguage: Language = Language.ENGLISH,
    val supportedLanguages: List<Language> = emptyList(),
    val lastResult: String = "",
    val confidence: Float = 0f,
    val error: String? = null
)