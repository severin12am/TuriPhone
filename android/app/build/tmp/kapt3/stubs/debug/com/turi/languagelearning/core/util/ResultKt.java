package com.turi.languagelearning.core.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001\u00a2\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002\u00a2\u0006\u0002\u0010\u0006\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00010\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u0011H\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\b0\nH\u0086\b\u00f8\u0001\u0000\u001aE\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\nH\u0086\b\u00f8\u0001\u0000\u001a0\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\b\u00f8\u0001\u0000\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u0011H\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00120\nH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2 = {"getOrDefault", "T", "Lcom/turi/languagelearning/core/util/Result;", "defaultValue", "(Lcom/turi/languagelearning/core/util/Result;Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "(Lcom/turi/languagelearning/core/util/Result;)Ljava/lang/Object;", "map", "R", "transform", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onError", "action", "", "exception", "", "onLoading", "Lkotlin/Function0;", "onSuccess", "app_debug"})
public final class ResultKt {
    
    /**
     * Extension functions for Result
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.turi.languagelearning.core.util.Result<T> onSuccess(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.turi.languagelearning.core.util.Result<T> onError(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$onError, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> action) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>com.turi.languagelearning.core.util.Result<T> onLoading(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$onLoading, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
        return null;
    }
    
    /**
     * Maps the success value to another type
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>com.turi.languagelearning.core.util.Result<R> map(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$map, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> transform) {
        return null;
    }
    
    /**
     * Returns the data if success, null otherwise
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>T getOrNull(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$getOrNull) {
        return null;
    }
    
    /**
     * Returns the data if success, default value otherwise
     */
    public static final <T extends java.lang.Object>T getOrDefault(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.util.Result<? extends T> $this$getOrDefault, T defaultValue) {
        return null;
    }
}