package com.turi.languagelearning.presentation.screens.language;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class LanguageSelectionViewModel_Factory implements Factory<LanguageSelectionViewModel> {
  @Override
  public LanguageSelectionViewModel get() {
    return newInstance();
  }

  public static LanguageSelectionViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LanguageSelectionViewModel newInstance() {
    return new LanguageSelectionViewModel();
  }

  private static final class InstanceHolder {
    private static final LanguageSelectionViewModel_Factory INSTANCE = new LanguageSelectionViewModel_Factory();
  }
}
