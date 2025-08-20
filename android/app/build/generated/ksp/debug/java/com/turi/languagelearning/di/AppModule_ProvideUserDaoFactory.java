package com.turi.languagelearning.di;

import com.turi.languagelearning.data.local.TuriDatabase;
import com.turi.languagelearning.data.local.dao.UserDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideUserDaoFactory implements Factory<UserDao> {
  private final Provider<TuriDatabase> databaseProvider;

  public AppModule_ProvideUserDaoFactory(Provider<TuriDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserDao get() {
    return provideUserDao(databaseProvider.get());
  }

  public static AppModule_ProvideUserDaoFactory create(Provider<TuriDatabase> databaseProvider) {
    return new AppModule_ProvideUserDaoFactory(databaseProvider);
  }

  public static UserDao provideUserDao(TuriDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserDao(database));
  }
}
