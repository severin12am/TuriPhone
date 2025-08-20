package com.turi.languagelearning.presentation.screens.dialogue;

import com.turi.languagelearning.services.GeminiService;
import com.turi.languagelearning.services.TextToSpeechService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DialogueViewModel_Factory implements Factory<DialogueViewModel> {
  private final Provider<TextToSpeechService> ttsServiceProvider;

  private final Provider<GeminiService> geminiServiceProvider;

  public DialogueViewModel_Factory(Provider<TextToSpeechService> ttsServiceProvider,
      Provider<GeminiService> geminiServiceProvider) {
    this.ttsServiceProvider = ttsServiceProvider;
    this.geminiServiceProvider = geminiServiceProvider;
  }

  @Override
  public DialogueViewModel get() {
    return newInstance(ttsServiceProvider.get(), geminiServiceProvider.get());
  }

  public static DialogueViewModel_Factory create(Provider<TextToSpeechService> ttsServiceProvider,
      Provider<GeminiService> geminiServiceProvider) {
    return new DialogueViewModel_Factory(ttsServiceProvider, geminiServiceProvider);
  }

  public static DialogueViewModel newInstance(TextToSpeechService ttsService,
      GeminiService geminiService) {
    return new DialogueViewModel(ttsService, geminiService);
  }
}
