package com.turi.languagelearning.features.speech.data

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import com.turi.languagelearning.core.model.Language
import com.turi.languagelearning.features.speech.domain.SpeechResult
import com.turi.languagelearning.features.speech.domain.SpeechService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Native Android implementation of speech services
 * Supports 8 languages: EN, RU, ES, AR, DE, JA, CH, FR
 */
@Singleton
class AndroidSpeechService @Inject constructor(
    @ApplicationContext private val context: Context
) : SpeechService {

    private val TAG = "AndroidSpeechService"
    
    // TTS
    private var tts: TextToSpeech? = null
    private var isTtsInitialized = false
    private var currentTtsLanguage = Language.ENGLISH
    
    // Speech Recognition
    private var speechRecognizer: SpeechRecognizer? = null
    private var isSpeechInitialized = false
    private var currentSpeechLanguage = Language.ENGLISH
    private var isCurrentlyListening = false
    
    // Settings
    private var speechRate = 1.0f
    private var pitch = 1.0f
    
    override fun initialize() {
        initializeTts()
        initializeSpeechRecognition()
    }
    
    private fun initializeTts() {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isTtsInitialized = true
                setupTtsListener()
                Log.i(TAG, "TTS initialized successfully")
            } else {
                Log.e(TAG, "TTS initialization failed")
            }
        }
    }
    
    private fun initializeSpeechRecognition() {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
            isSpeechInitialized = true
            Log.i(TAG, "Speech recognition initialized successfully")
        } else {
            Log.e(TAG, "Speech recognition not available")
        }
    }
    
    private fun setupTtsListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                Log.d(TAG, "TTS started: $utteranceId")
            }
            
            override fun onDone(utteranceId: String?) {
                Log.d(TAG, "TTS completed: $utteranceId")
            }
            
            override fun onError(utteranceId: String?) {
                Log.e(TAG, "TTS error: $utteranceId")
            }
        })
    }
    
    // TTS Implementation
    override suspend fun speak(text: String, language: Language) {
        if (!isTtsInitialized) {
            Log.w(TAG, "TTS not initialized")
            return
        }
        
        tts?.let { textToSpeech ->
            // Set language if different
            if (currentTtsLanguage != language) {
                val result = textToSpeech.setLanguage(language.ttsLocale)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e(TAG, "Language not supported: ${language.displayName}")
                    return
                }
                currentTtsLanguage = language
            }
            
            // Set speech rate and pitch
            textToSpeech.setSpeechRate(speechRate)
            textToSpeech.setPitch(pitch)
            
            // Speak
            val params = Bundle().apply {
                putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "utterance_${System.currentTimeMillis()}")
            }
            
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, params, params.getString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID))
            Log.i(TAG, "Speaking in ${language.displayName}: $text")
        }
    }
    
    override suspend fun speakWithCallback(
        text: String,
        language: Language,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String) -> Unit
    ) {
        if (!isTtsInitialized) {
            onError("TTS not initialized")
            return
        }
        
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                onStart()
            }
            
            override fun onDone(utteranceId: String?) {
                onComplete()
            }
            
            override fun onError(utteranceId: String?) {
                onError("TTS playback error")
            }
        })
        
        speak(text, language)
    }
    
    override fun stopSpeaking() {
        tts?.stop()
    }
    
    override fun isSpeaking(): Boolean {
        return tts?.isSpeaking == true
    }
    
    // Speech Recognition Implementation
    override suspend fun startListening(language: Language): Flow<SpeechResult> = callbackFlow {
        if (!isSpeechInitialized) {
            trySend(SpeechResult.Error("Speech recognition not initialized", -1))
            close()
            return@callbackFlow
        }
        
        val recognizer = speechRecognizer ?: run {
            trySend(SpeechResult.Error("Speech recognizer not available", -1))
            close()
            return@callbackFlow
        }
        
        val listener = object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {
                isCurrentlyListening = true
                trySend(SpeechResult.Listening)
            }
            
            override fun onBeginningOfSpeech() {
                Log.d(TAG, "Speech input started")
            }
            
            override fun onRmsChanged(rmsdB: Float) {
                // Audio level changed
            }
            
            override fun onBufferReceived(buffer: ByteArray?) {
                // Audio buffer received
            }
            
            override fun onEndOfSpeech() {
                isCurrentlyListening = false
                Log.d(TAG, "Speech input ended")
            }
            
            override fun onError(error: Int) {
                isCurrentlyListening = false
                val errorMessage = getSpeechErrorMessage(error)
                trySend(SpeechResult.Error(errorMessage, error))
                Log.e(TAG, "Speech recognition error: $errorMessage")
            }
            
            override fun onResults(results: Bundle?) {
                isCurrentlyListening = false
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                val confidence = results?.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES)
                
                if (!matches.isNullOrEmpty()) {
                    val text = matches[0]
                    val conf = confidence?.get(0) ?: 0.5f
                    trySend(SpeechResult.FinalResult(text, conf))
                    Log.i(TAG, "Speech result: $text (confidence: $conf)")
                }
            }
            
            override fun onPartialResults(partialResults: Bundle?) {
                val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (!matches.isNullOrEmpty()) {
                    trySend(SpeechResult.PartialResult(matches[0], 0.5f))
                }
            }
            
            override fun onEvent(eventType: Int, params: Bundle?) {
                // Additional events
            }
        }
        
        recognizer.setRecognitionListener(listener)
        
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, language.speechLocale.toString())
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, language.speechLocale.toString())
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
        }
        
        try {
            recognizer.startListening(intent)
            currentSpeechLanguage = language
            Log.i(TAG, "Started listening in ${language.displayName}")
        } catch (e: Exception) {
            trySend(SpeechResult.Error("Failed to start listening: ${e.message}", -1))
            close()
        }
        
        awaitClose {
            recognizer.stopListening()
            isCurrentlyListening = false
        }
    }
    
    override fun stopListening() {
        speechRecognizer?.stopListening()
        isCurrentlyListening = false
    }
    
    override fun isListening(): Boolean = isCurrentlyListening
    
    // Language Support
    override fun getSupportedTtsLanguages(): List<Language> {
        if (!isTtsInitialized) return emptyList()
        
        return Language.getAllLanguages().filter { language ->
            val result = tts?.isLanguageAvailable(language.ttsLocale)
            result == TextToSpeech.LANG_AVAILABLE || 
            result == TextToSpeech.LANG_COUNTRY_AVAILABLE ||
            result == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
        }
    }
    
    override fun getSupportedSpeechLanguages(): List<Language> {
        // All languages are supported by Android Speech Recognition
        return Language.getAllLanguages()
    }
    
    override fun isLanguageSupported(language: Language): Boolean {
        val ttsSupported = tts?.isLanguageAvailable(language.ttsLocale) != TextToSpeech.LANG_NOT_SUPPORTED
        return ttsSupported && isSpeechInitialized
    }
    
    // Settings
    override fun setSpeechRate(rate: Float) {
        speechRate = rate.coerceIn(0.1f, 3.0f)
        tts?.setSpeechRate(speechRate)
    }
    
    override fun setPitch(pitch: Float) {
        this.pitch = pitch.coerceIn(0.1f, 2.0f)
        tts?.setPitch(this.pitch)
    }
    
    // Lifecycle
    override fun cleanup() {
        tts?.stop()
        tts?.shutdown()
        speechRecognizer?.destroy()
        
        tts = null
        speechRecognizer = null
        isTtsInitialized = false
        isSpeechInitialized = false
        isCurrentlyListening = false
        
        Log.i(TAG, "Speech service cleaned up")
    }
    
    private fun getSpeechErrorMessage(error: Int): String {
        return when (error) {
            SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
            SpeechRecognizer.ERROR_CLIENT -> "Client side error"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions"
            SpeechRecognizer.ERROR_NETWORK -> "Network error"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout"
            SpeechRecognizer.ERROR_NO_MATCH -> "No speech input matched"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Recognition service busy"
            SpeechRecognizer.ERROR_SERVER -> "Server error"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input"
            else -> "Unknown error ($error)"
        }
    }
}