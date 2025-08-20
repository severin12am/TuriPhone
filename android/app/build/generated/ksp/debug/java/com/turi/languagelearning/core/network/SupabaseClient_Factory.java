package com.turi.languagelearning.core.network;

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
public final class SupabaseClient_Factory implements Factory<SupabaseClient> {
  @Override
  public SupabaseClient get() {
    return newInstance();
  }

  public static SupabaseClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SupabaseClient newInstance() {
    return new SupabaseClient();
  }

  private static final class InstanceHolder {
    private static final SupabaseClient_Factory INSTANCE = new SupabaseClient_Factory();
  }
}
