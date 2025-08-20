package com.turi.languagelearning.features.conversation.domain;

import com.turi.languagelearning.core.model.Language;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/turi/languagelearning/features/conversation/domain/WordExplanation;", "", "word", "", "language", "Lcom/turi/languagelearning/core/model/Language;", "translation", "pronunciation", "partOfSpeech", "definition", "examples", "", "grammarNotes", "culturalContext", "(Ljava/lang/String;Lcom/turi/languagelearning/core/model/Language;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCulturalContext", "()Ljava/lang/String;", "getDefinition", "getExamples", "()Ljava/util/List;", "getGrammarNotes", "getLanguage", "()Lcom/turi/languagelearning/core/model/Language;", "getPartOfSpeech", "getPronunciation", "getTranslation", "getWord", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class WordExplanation {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String word = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.core.model.Language language = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String translation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pronunciation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String partOfSpeech = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String definition = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> examples = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String grammarNotes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String culturalContext = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.Language component2() {
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
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.conversation.domain.WordExplanation copy(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    java.lang.String translation, @org.jetbrains.annotations.NotNull()
    java.lang.String pronunciation, @org.jetbrains.annotations.NotNull()
    java.lang.String partOfSpeech, @org.jetbrains.annotations.NotNull()
    java.lang.String definition, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> examples, @org.jetbrains.annotations.Nullable()
    java.lang.String grammarNotes, @org.jetbrains.annotations.Nullable()
    java.lang.String culturalContext) {
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
    
    public WordExplanation(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.Language language, @org.jetbrains.annotations.NotNull()
    java.lang.String translation, @org.jetbrains.annotations.NotNull()
    java.lang.String pronunciation, @org.jetbrains.annotations.NotNull()
    java.lang.String partOfSpeech, @org.jetbrains.annotations.NotNull()
    java.lang.String definition, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> examples, @org.jetbrains.annotations.Nullable()
    java.lang.String grammarNotes, @org.jetbrains.annotations.Nullable()
    java.lang.String culturalContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.Language getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTranslation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPronunciation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPartOfSpeech() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDefinition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExamples() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGrammarNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCulturalContext() {
        return null;
    }
}