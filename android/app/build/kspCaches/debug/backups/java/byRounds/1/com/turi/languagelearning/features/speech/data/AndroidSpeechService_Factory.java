package com.turi.languagelearning.features.speech.data;

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
public final class AndroidSpeechService_Factory implements Factory<AndroidSpeechService> {
  private final Provider<Context> contextProvider;

  public AndroidSpeechService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AndroidSpeechService get() {
    return newInstance(contextProvider.get());
  }

  public static AndroidSpeechService_Factory create(Provider<Context> contextProvider) {
    return new AndroidSpeechService_Factory(contextProvider);
  }

  public static AndroidSpeechService newInstance(Context context) {
    return new AndroidSpeechService(context);
  }
}
