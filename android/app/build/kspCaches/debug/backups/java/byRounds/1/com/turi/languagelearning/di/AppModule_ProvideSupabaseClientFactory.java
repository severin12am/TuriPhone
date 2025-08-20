package com.turi.languagelearning.di;

import com.turi.languagelearning.data.remote.SupabaseClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideSupabaseClientFactory implements Factory<SupabaseClient> {
  @Override
  public SupabaseClient get() {
    return provideSupabaseClient();
  }

  public static AppModule_ProvideSupabaseClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SupabaseClient provideSupabaseClient() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSupabaseClient());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideSupabaseClientFactory INSTANCE = new AppModule_ProvideSupabaseClientFactory();
  }
}
