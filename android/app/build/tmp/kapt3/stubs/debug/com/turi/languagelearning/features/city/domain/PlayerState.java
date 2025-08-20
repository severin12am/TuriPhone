package com.turi.languagelearning.features.city.domain;

import com.turi.languagelearning.features.conversation.domain.Character;

/**
 * Player state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/PlayerState;", "", "position", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "rotation", "movementSpeed", "", "rotationSpeed", "isMoving", "", "(Lcom/turi/languagelearning/features/city/domain/Vector3;Lcom/turi/languagelearning/features/city/domain/Vector3;FFZ)V", "()Z", "getMovementSpeed", "()F", "getPosition", "()Lcom/turi/languagelearning/features/city/domain/Vector3;", "getRotation", "getRotationSpeed", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class PlayerState {
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.Vector3 position = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.Vector3 rotation = null;
    private final float movementSpeed = 0.0F;
    private final float rotationSpeed = 0.0F;
    private final boolean isMoving = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 component2() {
        return null;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.PlayerState copy(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 rotation, float movementSpeed, float rotationSpeed, boolean isMoving) {
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
    
    public PlayerState(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 rotation, float movementSpeed, float rotationSpeed, boolean isMoving) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.Vector3 getRotation() {
        return null;
    }
    
    public final float getMovementSpeed() {
        return 0.0F;
    }
    
    public final float getRotationSpeed() {
        return 0.0F;
    }
    
    public final boolean isMoving() {
        return false;
    }
    
    public PlayerState() {
        super();
    }
}