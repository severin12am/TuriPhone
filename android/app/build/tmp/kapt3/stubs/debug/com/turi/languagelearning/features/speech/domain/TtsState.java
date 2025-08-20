package com.turi.languagelearning.features.speech.domain;

import com.turi.languagelearning.core.model.Language;
import kotlinx.coroutines.flow.Flow;

/**
 * TTS state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u00c6\u0003JW\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/turi/languagelearning/features/speech/domain/TtsState;", "", "isInitialized", "", "isSpeaking", "currentLanguage", "Lcom/turi/languagelearning/core/model/Language;", "supportedLanguages", "", "speechRate", "", "pitch", "error", "", "(ZZLcom/turi/languagelearning/core/model/Language;Ljava/util/List;FFLjava/lang/String;)V", "getCurrentLanguage", "()Lcom/turi/languagelearning/core/model/Language;", "getError", "()Ljava/lang/String;", "()Z", "getPitch", "()F", "getSpeechRate", "getSupportedLanguages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class TtsState {
    private final boolean isInitialized = false;
    private final boolean isSpeaking = false;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.core.model.Language currentLanguage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.turi.languagelearning.core.model.Language> supportedLanguages = null;
    private final float speechRate = 0.0F;
    private final float pitch = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.Language component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.core.model.Language> component4() {
        return null;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.speech.domain.TtsState copy(boolean isInitialized, boolean isSpeaking, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.turi.languagelearning.core.model.Language> supportedLanguages, float speechRate, float pitch, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public TtsState(boolean isInitialized, boolean isSpeaking, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language currentLanguage, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.turi.languagelearning.core.model.Language> supportedLanguages, float speechRate, float pitch, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    public final boolean isInitialized() {
        return false;
    }
    
    public final boolean isSpeaking() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.Language getCurrentLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.core.model.Language> getSupportedLanguages() {
        return null;
    }
    
    public final float getSpeechRate() {
        return 0.0F;
    }
    
    public final float getPitch() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public TtsState() {
        super();
    }
}