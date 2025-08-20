package com.turi.languagelearning.core.network;

import com.turi.languagelearning.core.model.User;
import com.turi.languagelearning.core.model.LearningProgress;
import com.turi.languagelearning.core.model.UserSession;
import io.github.jan.supabase.gotrue.Auth;
import io.github.jan.supabase.gotrue.auth;
import io.github.jan.supabase.gotrue.providers.builtin.Email;
import io.github.jan.supabase.postgrest.Postgrest;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Clean Supabase client for native Android
 * Handles authentication and data persistence
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J*\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u000fJ$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0014\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0007J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010\u001cJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\"\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"Lcom/turi/languagelearning/core/network/SupabaseClient;", "", "()V", "supabase", "Lio/github/jan/supabase/SupabaseClient;", "getCurrentUser", "Lcom/turi/languagelearning/core/model/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLearningProgress", "Lkotlin/Result;", "", "Lcom/turi/languagelearning/core/model/LearningProgress;", "userId", "", "getLearningProgress-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProfile", "getUserProfile-gIAlu-s", "saveLearningProgress", "", "progress", "saveLearningProgress-gIAlu-s", "(Lcom/turi/languagelearning/core/model/LearningProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "Lcom/turi/languagelearning/core/model/UserSession;", "email", "password", "signIn-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "signOut-IoAF18A", "signUp", "signUp-0E7RQCE", "updateUserProfile", "user", "updateUserProfile-gIAlu-s", "(Lcom/turi/languagelearning/core/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SupabaseClient {
    @org.jetbrains.annotations.NotNull()
    private final io.github.jan.supabase.SupabaseClient supabase = null;
    
    @javax.inject.Inject()
    public SupabaseClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.core.model.User> $completion) {
        return null;
    }
}