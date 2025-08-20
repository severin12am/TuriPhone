package com.turi.languagelearning.features.conversation.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class GeminiConversationService_Factory implements Factory<GeminiConversationService> {
  @Override
  public GeminiConversationService get() {
    return newInstance();
  }

  public static GeminiConversationService_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeminiConversationService newInstance() {
    return new GeminiConversationService();
  }

  private static final class InstanceHolder {
    private static final GeminiConversationService_Factory INSTANCE = new GeminiConversationService_Factory();
  }
}
