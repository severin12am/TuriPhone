package com.turi.languagelearning.features.speech.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import com.turi.languagelearning.core.model.Language;
import com.turi.languagelearning.features.speech.domain.SpeechResult;
import com.turi.languagelearning.features.speech.domain.SpeechService;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Native Android implementation of speech services
 * Supports 8 languages: EN, RU, ES, AR, DE, JA, CH, FR
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000fH\u0016J\b\u0010\'\u001a\u00020\u0016H\u0002J\u001e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010*JN\u0010+\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160-2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001600H\u0096@\u00a2\u0006\u0002\u00101J\u001c\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010!\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/turi/languagelearning/features/speech/data/AndroidSpeechService;", "Lcom/turi/languagelearning/features/speech/domain/SpeechService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "currentSpeechLanguage", "Lcom/turi/languagelearning/core/model/Language;", "currentTtsLanguage", "isCurrentlyListening", "", "isSpeechInitialized", "isTtsInitialized", "pitch", "", "speechRate", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "tts", "Landroid/speech/tts/TextToSpeech;", "cleanup", "", "getSpeechErrorMessage", "error", "", "getSupportedSpeechLanguages", "", "getSupportedTtsLanguages", "initialize", "initializeSpeechRecognition", "initializeTts", "isLanguageSupported", "language", "isListening", "isSpeaking", "setPitch", "setSpeechRate", "rate", "setupTtsListener", "speak", "text", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "speakWithCallback", "onStart", "Lkotlin/Function0;", "onComplete", "onError", "Lkotlin/Function1;", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startListening", "Lkotlinx/coroutines/flow/Flow;", "Lcom/turi/languagelearning/features/speech/domain/SpeechResult;", "(Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopListening", "stopSpeaking", "app_debug"})
public final class AndroidSpeechService implements com.turi.languagelearning.features.speech.domain.SpeechService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AndroidSpeechService";
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech tts;
    private boolean isTtsInitialized = false;
    @org.jetbrains.annotations.NotNull()
    private com.turi.languagelearning.core.model.Language currentTtsLanguage = com.turi.languagelearning.core.model.Language.ENGLISH;
    @org.jetbrains.annotations.Nullable()
    private android.speech.SpeechRecognizer speechRecognizer;
    private boolean isSpeechInitialized = false;
    @org.jetbrains.annotations.NotNull()
    private com.turi.languagelearning.core.model.Language currentSpeechLanguage = com.turi.languagelearning.core.model.Language.ENGLISH;
    private boolean isCurrentlyListening = false;
    private float speechRate = 1.0F;
    private float pitch = 1.0F;
    
    @javax.inject.Inject()
    public AndroidSpeechService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public void initialize() {
    }
    
    private final void initializeTts() {
    }
    
    private final void initializeSpeechRecognition() {
    }
    
    private final void setupTtsListener() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object speak(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object speakWithCallback(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void stopSpeaking() {
    }
    
    @java.lang.Override()
    public boolean isSpeaking() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object startListening(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.turi.languagelearning.features.speech.domain.SpeechResult>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void stopListening() {
    }
    
    @java.lang.Override()
    public boolean isListening() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.turi.languagelearning.core.model.Language> getSupportedTtsLanguages() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.turi.languagelearning.core.model.Language> getSupportedSpeechLanguages() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isLanguageSupported(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language) {
        return false;
    }
    
    @java.lang.Override()
    public void setSpeechRate(float rate) {
    }
    
    @java.lang.Override()
    public void setPitch(float pitch) {
    }
    
    @java.lang.Override()
    public void cleanup() {
    }
    
    private final java.lang.String getSpeechErrorMessage(int error) {
        return null;
    }
}