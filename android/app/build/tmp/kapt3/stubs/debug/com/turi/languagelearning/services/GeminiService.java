package com.turi.languagelearning.services;

import android.util.Log;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/turi/languagelearning/services/GeminiService;", "", "()V", "TAG", "", "calculateSimilarity", "", "response1", "response2", "evaluateResponse", "userResponse", "expectedResponse", "language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateUserResponse", "explainWord", "word", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateDialogue", "characterName", "context", "difficulty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSampleDialogue", "generateWordExplanation", "getDialogueGenerationPrompt", "getWordExplanationPrompt", "app_debug"})
public final class GeminiService {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "GeminiService";
    
    @javax.inject.Inject()
    public GeminiService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object explainWord(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateDialogue(@org.jetbrains.annotations.NotNull()
    java.lang.String characterName, @org.jetbrains.annotations.NotNull()
    java.lang.String context, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulty, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object evaluateResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String userResponse, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedResponse, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.String generateWordExplanation(java.lang.String word, java.lang.String language) {
        return null;
    }
    
    private final java.lang.String generateSampleDialogue(java.lang.String characterName, java.lang.String context, java.lang.String language, java.lang.String difficulty) {
        return null;
    }
    
    private final java.lang.String evaluateUserResponse(java.lang.String userResponse, java.lang.String expectedResponse, java.lang.String language) {
        return null;
    }
    
    private final double calculateSimilarity(java.lang.String response1, java.lang.String response2) {
        return 0.0;
    }
    
    private final java.lang.String getWordExplanationPrompt(java.lang.String word, java.lang.String language) {
        return null;
    }
    
    private final java.lang.String getDialogueGenerationPrompt(java.lang.String characterName, java.lang.String context, java.lang.String language, java.lang.String difficulty) {
        return null;
    }
}