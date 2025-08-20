package com.turi.languagelearning.presentation.screens.dialogue;

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.turi.languagelearning.domain.model.Dialogue;
import com.turi.languagelearning.domain.model.DialogueOption;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a>\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a8\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a,\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003\u001a\u001e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003\u001a0\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\u001e\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003\u001a\u001e\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"CharacterMessage", "", "dialogue", "Lcom/turi/languagelearning/domain/model/Dialogue;", "onWordTapped", "Lkotlin/Function1;", "", "ClickableText", "text", "style", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "ClickableText-9LQNqLg", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function1;)V", "DialogueContent", "onOptionSelected", "Lcom/turi/languagelearning/domain/model/DialogueOption;", "DialogueHeader", "characterName", "onBackPressed", "Lkotlin/Function0;", "onSpeakPressed", "DialogueOptionCard", "option", "onSelected", "DialogueScreen", "characterId", "viewModel", "Lcom/turi/languagelearning/presentation/screens/dialogue/DialogueViewModel;", "ErrorMessage", "error", "onRetry", "WordExplanationModal", "explanation", "onDismiss", "app_debug"})
public final class DialogueScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void DialogueScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId, @org.jetbrains.annotations.NotNull()
    java.lang.String characterName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackPressed, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.presentation.screens.dialogue.DialogueViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DialogueHeader(java.lang.String characterName, kotlin.jvm.functions.Function0<kotlin.Unit> onBackPressed, kotlin.jvm.functions.Function0<kotlin.Unit> onSpeakPressed) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DialogueContent(com.turi.languagelearning.domain.model.Dialogue dialogue, kotlin.jvm.functions.Function1<? super com.turi.languagelearning.domain.model.DialogueOption, kotlin.Unit> onOptionSelected, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onWordTapped) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CharacterMessage(com.turi.languagelearning.domain.model.Dialogue dialogue, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onWordTapped) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DialogueOptionCard(com.turi.languagelearning.domain.model.DialogueOption option, kotlin.jvm.functions.Function0<kotlin.Unit> onSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void WordExplanationModal(java.lang.String explanation, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ErrorMessage(java.lang.String error, kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
}