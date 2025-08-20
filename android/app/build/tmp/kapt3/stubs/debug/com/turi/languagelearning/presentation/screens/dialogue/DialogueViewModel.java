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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0016J\u0016\u0010\"\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/turi/languagelearning/presentation/screens/dialogue/DialogueViewModel;", "Landroidx/lifecycle/ViewModel;", "ttsService", "Lcom/turi/languagelearning/services/TextToSpeechService;", "geminiService", "Lcom/turi/languagelearning/services/GeminiService;", "(Lcom/turi/languagelearning/services/TextToSpeechService;Lcom/turi/languagelearning/services/GeminiService;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/turi/languagelearning/presentation/screens/dialogue/DialogueUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createSampleDialogue", "Lcom/turi/languagelearning/domain/model/Dialogue;", "characterId", "", "characterName", "createSampleFollowUpDialogue", "userResponse", "dismissWordExplanation", "", "explainWord", "word", "generateInitialDialogue", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateNextDialogue", "language", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectDialogueOption", "option", "Lcom/turi/languagelearning/domain/model/DialogueOption;", "speakCurrentDialogue", "startDialogue", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DialogueViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.services.TextToSpeechService ttsService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.services.GeminiService geminiService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.turi.languagelearning.presentation.screens.dialogue.DialogueUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.turi.languagelearning.presentation.screens.dialogue.DialogueUiState> uiState = null;
    
    @javax.inject.Inject()
    public DialogueViewModel(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.services.TextToSpeechService ttsService, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.services.GeminiService geminiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.turi.languagelearning.presentation.screens.dialogue.DialogueUiState> getUiState() {
        return null;
    }
    
    public final void startDialogue(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId, @org.jetbrains.annotations.NotNull()
    java.lang.String characterName) {
    }
    
    public final void selectDialogueOption(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.domain.model.DialogueOption option) {
    }
    
    public final void speakCurrentDialogue() {
    }
    
    public final void explainWord(@org.jetbrains.annotations.NotNull()
    java.lang.String word) {
    }
    
    public final void dismissWordExplanation() {
    }
    
    private final java.lang.Object generateInitialDialogue(java.lang.String characterId, java.lang.String characterName, kotlin.coroutines.Continuation<? super com.turi.languagelearning.domain.model.Dialogue> $completion) {
        return null;
    }
    
    private final java.lang.Object generateNextDialogue(java.lang.String characterName, java.lang.String userResponse, java.lang.String language, kotlin.coroutines.Continuation<? super com.turi.languagelearning.domain.model.Dialogue> $completion) {
        return null;
    }
    
    private final com.turi.languagelearning.domain.model.Dialogue createSampleDialogue(java.lang.String characterId, java.lang.String characterName) {
        return null;
    }
    
    private final com.turi.languagelearning.domain.model.Dialogue createSampleFollowUpDialogue(java.lang.String characterName, java.lang.String userResponse) {
        return null;
    }
}