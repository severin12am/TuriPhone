package com.turi.languagelearning.features.conversation.domain;

import com.turi.languagelearning.core.model.Language;

/**
 * Clean conversation service for Gemini AI integration
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\fJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u00a6@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/turi/languagelearning/features/conversation/domain/ConversationService;", "", "continueConversation", "Lcom/turi/languagelearning/features/conversation/domain/ConversationResult;", "conversationId", "", "userInput", "language", "Lcom/turi/languagelearning/core/model/Language;", "(Ljava/lang/String;Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endConversation", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateResponse", "Lcom/turi/languagelearning/features/conversation/domain/ResponseEvaluation;", "userResponse", "expectedResponse", "explainGrammar", "Lcom/turi/languagelearning/features/conversation/domain/GrammarExplanation;", "sentence", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "explainWord", "Lcom/turi/languagelearning/features/conversation/domain/WordExplanation;", "word", "context", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConversation", "characterName", "userLevel", "", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ConversationService {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String characterName, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, int userLevel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.conversation.domain.ConversationResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object continueConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String userInput, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.conversation.domain.ConversationResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object endConversation(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object explainWord(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.Nullable()
    java.lang.String context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.conversation.domain.WordExplanation> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object explainGrammar(@org.jetbrains.annotations.NotNull()
    java.lang.String sentence, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.conversation.domain.GrammarExplanation> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object evaluateResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String userResponse, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedResponse, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.conversation.domain.ResponseEvaluation> $completion);
    
    /**
     * Clean conversation service for Gemini AI integration
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}