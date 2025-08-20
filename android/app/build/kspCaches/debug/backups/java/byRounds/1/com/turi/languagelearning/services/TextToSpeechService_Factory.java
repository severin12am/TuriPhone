package com.turi.languagelearning.services;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class TextToSpeechService_Factory implements Factory<TextToSpeechService> {
  private final Provider<Context> contextProvider;

  public TextToSpeechService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TextToSpeechService get() {
    return newInstance(contextProvider.get());
  }

  public static TextToSpeechService_Factory create(Provider<Context> contextProvider) {
    return new TextToSpeechService_Factory(contextProvider);
  }

  public static TextToSpeechService newInstance(Context context) {
    return new TextToSpeechService(context);
  }
}
