package com.turi.languagelearning.features.conversation.domain;

import com.turi.languagelearning.core.model.Language;

/**
 * Conversation models
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\t\u0010!\u001a\u00020\fH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000eH\u00c6\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\fH\u00d6\u0001J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/turi/languagelearning/features/conversation/domain/ConversationResult;", "", "conversationId", "", "characterName", "characterMessage", "translation", "responseOptions", "", "Lcom/turi/languagelearning/features/conversation/domain/ResponseOption;", "learningTips", "difficulty", "", "isComplete", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IZ)V", "getCharacterMessage", "()Ljava/lang/String;", "getCharacterName", "getConversationId", "getDifficulty", "()I", "()Z", "getLearningTips", "()Ljava/util/List;", "getResponseOptions", "getTranslation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ConversationResult {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String conversationId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String characterName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String characterMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String translation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.turi.languagelearning.features.conversation.domain.ResponseOption> responseOptions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> learningTips = null;
    private final int difficulty = 0;
    private final boolean isComplete = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.features.conversation.domain.ResponseOption> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.conversation.domain.ConversationResult copy(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String characterName, @org.jetbrains.annotations.NotNull()
    java.lang.String characterMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String translation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.turi.languagelearning.features.conversation.domain.ResponseOption> responseOptions, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> learningTips, int difficulty, boolean isComplete) {
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
    
    public ConversationResult(@org.jetbrains.annotations.NotNull()
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull()
    java.lang.String characterName, @org.jetbrains.annotations.NotNull()
    java.lang.String characterMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String translation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.turi.languagelearning.features.conversation.domain.ResponseOption> responseOptions, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> learningTips, int difficulty, boolean isComplete) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getConversationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCharacterName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCharacterMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTranslation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.features.conversation.domain.ResponseOption> getResponseOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getLearningTips() {
        return null;
    }
    
    public final int getDifficulty() {
        return 0;
    }
    
    public final boolean isComplete() {
        return false;
    }
}