package com.turi.languagelearning.presentation.screens.splash;

import androidx.lifecycle.ViewModel;
import com.turi.languagelearning.data.local.dao.UserDao;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/turi/languagelearning/presentation/screens/splash/SplashUiState;", "", "isLoading", "", "loadingMessage", "", "navigationDestination", "Lcom/turi/languagelearning/presentation/screens/splash/SplashNavigationDestination;", "(ZLjava/lang/String;Lcom/turi/languagelearning/presentation/screens/splash/SplashNavigationDestination;)V", "()Z", "getLoadingMessage", "()Ljava/lang/String;", "getNavigationDestination", "()Lcom/turi/languagelearning/presentation/screens/splash/SplashNavigationDestination;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SplashUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String loadingMessage = null;
    @org.jetbrains.annotations.Nullable()
    private final com.turi.languagelearning.presentation.screens.splash.SplashNavigationDestination navigationDestination = null;
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.presentation.screens.splash.SplashNavigationDestination component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.presentation.screens.splash.SplashUiState copy(boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.lang.String loadingMessage, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.presentation.screens.splash.SplashNavigationDestination navigationDestination) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public SplashUiState(boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.lang.String loadingMessage, @org.jetbrains.annotations.Nullable()
    com.turi.languagelearning.presentation.screens.splash.SplashNavigationDestination navigationDestination) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoadingMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.turi.languagelearning.presentation.screens.splash.SplashNavigationDestination getNavigationDestination() {
        return null;
    }
    
    public SplashUiState() {
        super();
    }
}