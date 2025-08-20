package com.turi.languagelearning.features.conversation.domain;

import com.turi.languagelearning.core.model.Language;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003Ja\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/turi/languagelearning/features/conversation/domain/ResponseEvaluation;", "", "userResponse", "", "isCorrect", "", "accuracy", "", "feedback", "corrections", "", "suggestions", "grammarTips", "(Ljava/lang/String;ZFLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAccuracy", "()F", "getCorrections", "()Ljava/util/List;", "getFeedback", "()Ljava/lang/String;", "getGrammarTips", "()Z", "getSuggestions", "getUserResponse", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ResponseEvaluation {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userResponse = null;
    private final boolean isCorrect = false;
    private final float accuracy = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String feedback = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> corrections = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> suggestions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> grammarTips = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.conversation.domain.ResponseEvaluation copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userResponse, boolean isCorrect, float accuracy, @org.jetbrains.annotations.NotNull()
    java.lang.String feedback, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> corrections, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> suggestions, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grammarTips) {
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
    
    public ResponseEvaluation(@org.jetbrains.annotations.NotNull()
    java.lang.String userResponse, boolean isCorrect, float accuracy, @org.jetbrains.annotations.NotNull()
    java.lang.String feedback, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> corrections, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> suggestions, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grammarTips) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserResponse() {
        return null;
    }
    
    public final boolean isCorrect() {
        return false;
    }
    
    public final float getAccuracy() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFeedback() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCorrections() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSuggestions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGrammarTips() {
        return null;
    }
}