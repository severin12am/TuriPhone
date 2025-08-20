package com.turi.languagelearning.presentation.screens.dialogue;

import androidx.lifecycle.ViewModel;
import com.turi.languagelearning.domain.model.Dialogue;
import com.turi.languagelearning.domain.model.DialogueOption;
import com.turi.languagelearning.domain.model.DialogueSession;
import com.turi.languagelearning.services.TextToSpeechService;
import com.turi.languagelearning.services.GeminiService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u00c6\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\tH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/turi/languagelearning/presentation/screens/dialogue/DialogueUiState;", "", "isLoading", "", "currentDialogue", "Lcom/turi/languagelearning/domain/model/Dialogue;", "dialogueSession", "Lcom/turi/languagelearning/domain/model/DialogueSession;", "wordExplanation", "", "error", "(ZLcom/turi/languagelearning/domain/model/Dialogue;Lcom/turi/languagelearning/domain/model/DialogueSession;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentDialogue", "()Lcom/turi/languagelearning/domain/model/Dialogue;", "getDialogueSession", "()Lcom/turi/languagelearning/domain/model/DialogueSession;", "getError", "()Ljava/lang/String;", "()Z", "getWordExplanation", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DialogueUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.turi.languagelearning.domain.model.Dialogue currentDialogue = null;
    @org.jetbrains.annotations.Nullable()
    private final com.turi.languagelearning.domain.model.DialogueSession dialogueSession = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String wordExplanation = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.domain.model.Dialogue component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.domain.model.DialogueSession component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.presentation.screens.dialogue.DialogueUiState copy(boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.domain.model.Dialogue currentDialogue, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.domain.model.DialogueSession dialogueSession, @org.jetbrains.annotations.Nullable()
    java.lang.String wordExplanation, @org.jetbrains.annotations.Nullable()
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
    
    public DialogueUiState(boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.domain.model.Dialogue currentDialogue, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.domain.model.DialogueSession dialogueSession, @org.jetbrains.annotations.Nullable()
    java.lang.String wordExplanation, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.domain.model.Dialogue getCurrentDialogue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.domain.model.DialogueSession getDialogueSession() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWordExplanation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public DialogueUiState() {
        super();
    }
}