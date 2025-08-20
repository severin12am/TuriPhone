package com.turi.languagelearning.services

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

data class SpeechRecognitionState(
    val isListening: Boolean = false,
    val isAvailable: Boolean = false,
    val currentLanguage: String = "es-ES",
    val recognizedText: String = "",
    val confidence: Float = 0f,
    val error: String? = null,
    val partialResults: List<String> = emptyList()
)

// @Singleton // Temporarily disabled
class SpeechRecognitionService /* @Inject constructor(
    @ApplicationContext private val context: Context
) */ {
    // Temporary mock dependency
    private val context: Context? = null
    
    private var speechRecognizer: SpeechRecognizer? = null
    private val _state = MutableStateFlow<SpeechRecognitionState>(SpeechRecognitionState())
    val state: StateFlow<SpeechRecognitionState> = _state.asStateFlow()
    
    private val languageMap = mapOf(
        "spanish" to "es-ES",
        "french" to "fr-FR",
        "german" to "de-DE",
        "italian" to "it-IT",
        "portuguese" to "pt-BR",
        "english" to "en-US"
    )
    
    private var onResultCallback: ((String, Float) -> Unit)? = null
    private var onErrorCallback: ((String) -> Unit)? = null
    
    init {
        initializeSpeechRecognizer()
    }
    
    private fun initializeSpeechRecognizer() {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
            speechRecognizer?.setRecognitionListener(recognitionListener)
            
            _state.value = _state.value.copy(isAvailable = true)
            Log.i("SpeechRecognition", "Speech recognition initialized successfully")
        } else {
            _state.value = _state.value.copy(
                isAvailable = false,
                error = "Speech recognition not available on this device"
            )
            Log.e("SpeechRecognition", "Speech recognition not available")
        }
    }
    
    private val recognitionListener = object : RecognitionListener {
        override fun onReadyForSpeech(params: Bundle?) {
            _state.value = _state.value.copy(
                isListening = true,
                error = null,
                recognizedText = "",
                partialResults = emptyList()
            )
            Log.i("SpeechRecognition", "Ready for speech")
        }
        
        override fun onBeginningOfSpeech() {
            Log.i("SpeechRecognition", "Beginning of speech detected")
        }
        
        override fun onRmsChanged(rmsdB: Float) {
            // Audio level changed - could be used for visual feedback
        }
        
        override fun onBufferReceived(buffer: ByteArray?) {
            // Audio buffer received
        }
        
        override fun onEndOfSpeech() {
            Log.i("SpeechRecognition", "End of speech")
        }
        
        override fun onError(error: Int) {
            val errorMessage = when (error) {
                SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
                SpeechRecognizer.ERROR_CLIENT -> "Client side error"
                SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions"
                SpeechRecognizer.ERROR_NETWORK -> "Network error"
                SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout"
                SpeechRecognizer.ERROR_NO_MATCH -> "No speech input matched"
                SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Recognition service busy"
                SpeechRecognizer.ERROR_SERVER -> "Server error"
                SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input"
                else -> "Unknown error"
            }
            
            _state.value = _state.value.copy(
                isListening = false,
                error = errorMessage
            )
            
            onErrorCallback?.invoke(errorMessage)
            Log.e("SpeechRecognition", "Recognition error: $errorMessage")
        }
        
        override fun onResults(results: Bundle?) {
            val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            val confidence = results?.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES)
            
            if (!matches.isNullOrEmpty()) {
                val recognizedText = matches[0]
                val confidenceScore = confidence?.get(0) ?: 0f
                
                _state.value = _state.value.copy(
                    isListening = false,
                    recognizedText = recognizedText,
                    confidence = confidenceScore,
                    error = null
                )
                
                onResultCallback?.invoke(recognizedText, confidenceScore)
                Log.i("SpeechRecognition", "Recognition result: $recognizedText (confidence: $confidenceScore)")
            }
        }
        
        override fun onPartialResults(partialResults: Bundle?) {
            val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (!matches.isNullOrEmpty()) {
                _state.value = _state.value.copy(partialResults = matches)
                Log.d("SpeechRecognition", "Partial results: $matches")
            }
        }
        
        override fun onEvent(eventType: Int, params: Bundle?) {
            // Additional events
        }
    }
    
    fun startListening(
        language: String = "spanish",
        onResult: (String, Float) -> Unit,
        onError: (String) -> Unit
    ) {
        if (!_state.value.isAvailable) {
            onError("Speech recognition not available")
            return
        }
        
        if (_state.value.isListening) {
            Log.w("SpeechRecognition", "Already listening")
            return
        }
        
        onResultCallback = onResult
        onErrorCallback = onError
        
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageMap[language] ?: "es-ES")
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, languageMap[language] ?: "es-ES")
            putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, false)
            putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
        }
        
        try {
            speechRecognizer?.startListening(intent)
            _state.value = _state.value.copy(currentLanguage = languageMap[language] ?: "es-ES")
            Log.i("SpeechRecognition", "Started listening for language: $language")
        } catch (e: Exception) {
            val errorMsg = "Failed to start listening: ${e.message}"
            _state.value = _state.value.copy(error = errorMsg)
            onError(errorMsg)
            Log.e("SpeechRecognition", errorMsg, e)
        }
    }
    
    fun stopListening() {
        speechRecognizer?.stopListening()
        _state.value = _state.value.copy(isListening = false)
        Log.i("SpeechRecognition", "Stopped listening")
    }
    
    fun cancel() {
        speechRecognizer?.cancel()
        _state.value = _state.value.copy(
            isListening = false,
            recognizedText = "",
            partialResults = emptyList(),
            error = null
        )
        Log.i("SpeechRecognition", "Recognition cancelled")
    }
    
    fun isListening(): Boolean {
        return _state.value.isListening
    }
    
    fun isAvailable(): Boolean {
        return _state.value.isAvailable
    }
    
    fun getSupportedLanguages(): List<String> {
        return languageMap.keys.toList()
    }
    
    fun setLanguage(language: String): Boolean {
        val locale = languageMap[language.lowercase()]
        if (locale != null) {
            _state.value = _state.value.copy(currentLanguage = locale)
            return true
        }
        return false
    }
    
    fun getCurrentLanguage(): String {
        return _state.value.currentLanguage
    }
    
    fun getLastRecognizedText(): String {
        return _state.value.recognizedText
    }
    
    fun getLastConfidence(): Float {
        return _state.value.confidence
    }
    
    fun cleanup() {
        speechRecognizer?.destroy()
        speechRecognizer = null
        onResultCallback = null
        onErrorCallback = null
        _state.value = SpeechRecognitionState()
    }
}