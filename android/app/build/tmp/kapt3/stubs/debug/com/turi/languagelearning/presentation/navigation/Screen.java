package com.turi.languagelearning.presentation.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0007\b\t\n\u000b\f\r\u000eB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Dialogue", "Game", "LanguageSelection", "Login", "Progress", "Quiz", "Settings", "Splash", "Lcom/turi/languagelearning/presentation/navigation/Screen$Dialogue;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Game;", "Lcom/turi/languagelearning/presentation/navigation/Screen$LanguageSelection;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Login;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Progress;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Quiz;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Settings;", "Lcom/turi/languagelearning/presentation/navigation/Screen$Splash;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Dialogue;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "createRoute", "", "characterId", "characterName", "app_debug"})
    public static final class Dialogue extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Dialogue INSTANCE = null;
        
        private Dialogue() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String characterId, @org.jetbrains.annotations.NotNull()
        java.lang.String characterName) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Game;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Game extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Game INSTANCE = null;
        
        private Game() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$LanguageSelection;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class LanguageSelection extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.LanguageSelection INSTANCE = null;
        
        private LanguageSelection() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Login;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Login extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Progress;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Progress extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Progress INSTANCE = null;
        
        private Progress() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Quiz;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Quiz extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Quiz INSTANCE = null;
        
        private Quiz() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Settings;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/presentation/navigation/Screen$Splash;", "Lcom/turi/languagelearning/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Splash extends com.turi.languagelearning.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.presentation.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
}