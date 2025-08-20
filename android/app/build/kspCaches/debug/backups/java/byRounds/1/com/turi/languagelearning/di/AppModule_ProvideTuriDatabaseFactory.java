package com.turi.languagelearning.di;

import android.content.Context;
import com.turi.languagelearning.data.local.TuriDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideTuriDatabaseFactory implements Factory<TuriDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideTuriDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TuriDatabase get() {
    return provideTuriDatabase(contextProvider.get());
  }

  public static AppModule_ProvideTuriDatabaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideTuriDatabaseFactory(contextProvider);
  }

  public static TuriDatabase provideTuriDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTuriDatabase(context));
  }
}
