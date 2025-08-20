package com.turi.languagelearning.services

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

data class TtsState(
    val isInitialized: Boolean = false,
    val isSpeaking: Boolean = false,
    val currentLanguage: String = "es",
    val availableLanguages: List<String> = emptyList(),
    val error: String? = null
)

@Singleton
class TextToSpeechService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private var tts: TextToSpeech? = null
    private val _state = MutableStateFlow(TtsState())
    val state: StateFlow<TtsState> = _state.asStateFlow()
    
    private val languageMap = mapOf(
        "spanish" to Locale("es", "ES"),
        "french" to Locale("fr", "FR"),
        "german" to Locale("de", "DE"),
        "italian" to Locale("it", "IT"),
        "portuguese" to Locale("pt", "BR"),
        "english" to Locale("en", "US")
    )
    
    init {
        initializeTts()
    }
    
    private fun initializeTts() {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                setupTts()
            } else {
                _state.value = _state.value.copy(
                    error = "TTS initialization failed"
                )
                Log.e("TTS", "TTS initialization failed with status: $status")
            }
        }
    }
    
    private fun setupTts() {
        tts?.let { textToSpeech ->
            // Set up utterance progress listener
            textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _state.value = _state.value.copy(isSpeaking = true)
                }
                
                override fun onDone(utteranceId: String?) {
                    _state.value = _state.value.copy(isSpeaking = false)
                }
                
                override fun onError(utteranceId: String?) {
                    _state.value = _state.value.copy(
                        isSpeaking = false,
                        error = "TTS playback error"
                    )
                }
            })
            
            // Check available languages
            val availableLanguages = mutableListOf<String>()
            languageMap.forEach { (language, locale) ->
                val result = textToSpeech.isLanguageAvailable(locale)
                if (result == TextToSpeech.LANG_AVAILABLE || 
                    result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
                    result == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE) {
                    availableLanguages.add(language)
                }
            }
            
            // Set default language to Spanish
            setLanguage("spanish")
            
            _state.value = _state.value.copy(
                isInitialized = true,
                availableLanguages = availableLanguages,
                error = null
            )
            
            Log.i("TTS", "TTS initialized successfully. Available languages: $availableLanguages")
        }
    }
    
    fun speak(text: String, language: String? = null) {
        if (!_state.value.isInitialized) {
            Log.w("TTS", "TTS not initialized, cannot speak")
            return
        }
        
        // Change language if specified
        language?.let { setLanguage(it) }
        
        tts?.let { textToSpeech ->
            // Stop any current speech
            stop()
            
            // Speak the text
            val params = Bundle().apply {
                putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "utterance_${System.currentTimeMillis()}")
            }
            
            val result = textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, params, params.getString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID))
            
            if (result == TextToSpeech.ERROR) {
                _state.value = _state.value.copy(error = "Failed to speak text")
                Log.e("TTS", "Failed to speak text: $text")
            } else {
                Log.i("TTS", "Speaking: $text")
            }
        }
    }
    
    fun setLanguage(language: String): Boolean {
        val locale = languageMap[language.lowercase()]
        if (locale == null) {
            _state.value = _state.value.copy(error = "Unsupported language: $language")
            return false
        }
        
        tts?.let { textToSpeech ->
            val result = textToSpeech.setLanguage(locale)
            
            when (result) {
                TextToSpeech.LANG_MISSING_DATA, TextToSpeech.LANG_NOT_SUPPORTED -> {
                    _state.value = _state.value.copy(error = "Language not supported: $language")
                    Log.e("TTS", "Language not supported: $language")
                    return false
                }
                else -> {
                    _state.value = _state.value.copy(
                        currentLanguage = language,
                        error = null
                    )
                    Log.i("TTS", "Language set to: $language")
                    return true
                }
            }
        }
        
        return false
    }
    
    fun setSpeechRate(rate: Float) {
        tts?.setSpeechRate(rate)
    }
    
    fun setPitch(pitch: Float) {
        tts?.setPitch(pitch)
    }
    
    fun stop() {
        tts?.stop()
        _state.value = _state.value.copy(isSpeaking = false)
    }
    
    fun pause() {
        // Note: TextToSpeech doesn't have a native pause, so we stop
        stop()
    }
    
    fun isSpeaking(): Boolean {
        return tts?.isSpeaking == true
    }
    
    fun getAvailableLanguages(): List<String> {
        return _state.value.availableLanguages
    }
    
    fun getCurrentLanguage(): String {
        return _state.value.currentLanguage
    }
    
    fun cleanup() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        _state.value = TtsState()
    }
}