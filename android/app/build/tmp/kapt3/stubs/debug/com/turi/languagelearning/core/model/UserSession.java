package com.turi.languagelearning.core.model;

/**
 * User session data
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJF\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/turi/languagelearning/core/model/UserSession;", "", "user", "Lcom/turi/languagelearning/core/model/User;", "isAuthenticated", "", "accessToken", "", "refreshToken", "expiresAt", "", "(Lcom/turi/languagelearning/core/model/User;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getRefreshToken", "getUser", "()Lcom/turi/languagelearning/core/model/User;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/turi/languagelearning/core/model/User;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/turi/languagelearning/core/model/UserSession;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class UserSession {
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.core.model.User user = null;
    private final boolean isAuthenticated = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String accessToken = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String refreshToken = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long expiresAt = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.User component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.UserSession copy(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.User user, boolean isAuthenticated, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    java.lang.String refreshToken, @org.jetbrains.annotations.Nullable()
    java.lang.Long expiresAt) {
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
    
    public UserSession(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.core.model.User user, boolean isAuthenticated, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    java.lang.String refreshToken, @org.jetbrains.annotations.Nullable()
    java.lang.Long expiresAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.core.model.User getUser() {
        return null;
    }
    
    public final boolean isAuthenticated() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRefreshToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getExpiresAt() {
        return null;
    }
}