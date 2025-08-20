package com.turi.languagelearning.features.city.domain;

import com.turi.languagelearning.features.conversation.domain.Character;

/**
 * Camera state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/CameraState;", "", "position", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "target", "up", "fov", "", "nearPlane", "farPlane", "(Lcom/turi/languagelearning/features/city/domain/Vector3;Lcom/turi/languagelearning/features/city/domain/Vector3;Lcom/turi/languagelearning/features/city/domain/Vector3;FFF)V", "getFarPlane", "()F", "getFov", "getNearPlane", "getPosition", "()Lcom/turi/languagelearning/features/city/domain/Vector3;", "getTarget", "getUp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CameraState {
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.Vector3 position = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.Vector3 target = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.Vector3 up = null;
    private final float fov = 0.0F;
    private final float nearPlane = 0.0F;
    private final float farPlane = 0.0F;
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 component3() {
        return null;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.CameraState copy(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 target, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 up, float fov, float nearPlane, float farPlane) {
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
    
    public CameraState(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 target, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 up, float fov, float nearPlane, float farPlane) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 getTarget() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 getUp() {
        return null;
    }
    
    public final float getFov() {
        return 0.0F;
    }
    
    public final float getNearPlane() {
        return 0.0F;
    }
    
    public final float getFarPlane() {
        return 0.0F;
    }
    
    public CameraState() {
        super();
    }
}