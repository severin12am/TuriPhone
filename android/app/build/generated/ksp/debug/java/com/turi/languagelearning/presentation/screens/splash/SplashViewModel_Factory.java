package com.turi.languagelearning.presentation.screens.splash;

import com.turi.languagelearning.data.local.dao.UserDao;
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
public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
  private final Provider<UserDao> userDaoProvider;

  public SplashViewModel_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public SplashViewModel get() {
    return newInstance(userDaoProvider.get());
  }

  public static SplashViewModel_Factory create(Provider<UserDao> userDaoProvider) {
    return new SplashViewModel_Factory(userDaoProvider);
  }

  public static SplashViewModel newInstance(UserDao userDao) {
    return new SplashViewModel(userDao);
  }
}
