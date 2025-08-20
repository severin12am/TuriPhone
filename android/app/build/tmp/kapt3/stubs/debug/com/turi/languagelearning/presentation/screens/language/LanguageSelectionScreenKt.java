package com.turi.languagelearning.presentation.screens.language;

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import com.turi.languagelearning.core.constants.Languages;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a4\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u001aX\u0010\u000f\u001a\u00020\u000126\u0010\r\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a4\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u00a8\u0006\u001a"}, d2 = {"LanguageItem", "", "language", "Lcom/turi/languagelearning/core/constants/LanguageOption;", "isSelected", "", "onSelected", "Lkotlin/Function0;", "LanguageList", "languages", "", "selectedLanguage", "", "onLanguageSelected", "Lkotlin/Function1;", "LanguageSelectionScreen", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "motherLanguage", "targetLanguage", "onLoginClicked", "viewModel", "Lcom/turi/languagelearning/presentation/screens/language/LanguageSelectionViewModel;", "ReadyToStartContent", "onStartJourney", "app_debug"})
public final class LanguageSelectionScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void LanguageSelectionScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onLanguageSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoginClicked, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.presentation.screens.language.LanguageSelectionViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LanguageList(java.util.List<com.turi.languagelearning.core.constants.LanguageOption> languages, java.lang.String selectedLanguage, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLanguageSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LanguageItem(com.turi.languagelearning.core.constants.LanguageOption language, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ReadyToStartContent(java.lang.String motherLanguage, java.lang.String targetLanguage, kotlin.jvm.functions.Function0<kotlin.Unit> onStartJourney, kotlin.jvm.functions.Function0<kotlin.Unit> onLoginClicked) {
    }
}