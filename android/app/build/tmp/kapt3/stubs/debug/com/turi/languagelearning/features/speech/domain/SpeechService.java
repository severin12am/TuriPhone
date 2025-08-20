package com.turi.languagelearning.features.speech.domain;

import com.turi.languagelearning.core.model.Language;
import kotlinx.coroutines.flow.Flow;

/**
 * Clean speech service interface for 8-language support
 * Native Android TTS and Speech Recognition
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0016JV\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u001cH\u00a6@\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&\u00a8\u0006$"}, d2 = {"Lcom/turi/languagelearning/features/speech/domain/SpeechService;", "", "cleanup", "", "getSupportedSpeechLanguages", "", "Lcom/turi/languagelearning/core/model/Language;", "getSupportedTtsLanguages", "initialize", "isLanguageSupported", "", "language", "isListening", "isSpeaking", "setPitch", "pitch", "", "setSpeechRate", "rate", "speak", "text", "", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "speakWithCallback", "onStart", "Lkotlin/Function0;", "onComplete", "onError", "Lkotlin/Function1;", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startListening", "Lkotlinx/coroutines/flow/Flow;", "Lcom/turi/languagelearning/features/speech/domain/SpeechResult;", "(Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopListening", "stopSpeaking", "app_debug"})
public abstract interface SpeechService {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object speak(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object speakWithCallback(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    public abstract void stopSpeaking();
    
    public abstract boolean isSpeaking();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startListening(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.turi.languagelearning.features.speech.domain.SpeechResult>> $completion);
    
    public abstract void stopListening();
    
    public abstract boolean isListening();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.turi.languagelearning.core.model.Language> getSupportedTtsLanguages();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.turi.languagelearning.core.model.Language> getSupportedSpeechLanguages();
    
    public abstract boolean isLanguageSupported(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language);
    
    public abstract void setSpeechRate(float rate);
    
    public abstract void setPitch(float pitch);
    
    public abstract void initialize();
    
    public abstract void cleanup();
    
    /**
     * Clean speech service interface for 8-language support
     * Native Android TTS and Speech Recognition
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}