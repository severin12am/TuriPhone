package com.turi.languagelearning.features.city.domain;

import com.turi.languagelearning.features.conversation.domain.Character;

/**
 * Clean 3D city exploration service
 * Native OpenGL/Vulkan implementation
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bH&J\b\u0010\u0019\u001a\u00020\u0003H&J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000bH&J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u00a6@\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\"H\u00a6@\u00a2\u0006\u0002\u0010 J \u0010#\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH&J\b\u0010%\u001a\u00020\u0003H&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0005H&\u00a8\u00060"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/CityService;", "", "cleanup", "", "getCameraPosition", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "getCameraTarget", "getCharacterAt", "Lcom/turi/languagelearning/features/conversation/domain/Character;", "position", "radius", "", "getNearbyCharacters", "", "getPlayerPosition", "getPlayerRotation", "handleTouchMove", "deltaX", "deltaY", "handleTouchTap", "Lcom/turi/languagelearning/features/city/domain/TouchResult;", "screenX", "screenY", "handleTouchZoom", "scale", "initialize", "isCharacterInRange", "", "characterId", "", "range", "loadCharacters", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCity", "Lcom/turi/languagelearning/features/city/domain/CityResult;", "movePlayer", "deltaZ", "render", "resize", "width", "", "height", "rotatePlayer", "yaw", "pitch", "setCameraPosition", "setCameraTarget", "target", "app_debug"})
public abstract interface CityService {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loadCity(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.turi.languagelearning.features.city.domain.CityResult> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object loadCharacters(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.turi.languagelearning.features.conversation.domain.Character>> $completion);
    
    public abstract void movePlayer(float deltaX, float deltaY, float deltaZ);
    
    public abstract void rotatePlayer(float yaw, float pitch);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.features.city.domain.Vector3 getPlayerPosition();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.features.city.domain.Vector3 getPlayerRotation();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.turi.languagelearning.features.conversation.domain.Character> getNearbyCharacters(float radius);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.turi.languagelearning.features.conversation.domain.Character getCharacterAt(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position, float radius);
    
    public abstract boolean isCharacterInRange(@org.jetbrains.annotations.NotNull()
    java.lang.String characterId, float range);
    
    public abstract void setCameraPosition(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 position);
    
    public abstract void setCameraTarget(@org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.Vector3 target);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.features.city.domain.Vector3 getCameraPosition();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.features.city.domain.Vector3 getCameraTarget();
    
    public abstract void handleTouchMove(float deltaX, float deltaY);
    
    public abstract void handleTouchZoom(float scale);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.features.city.domain.TouchResult handleTouchTap(float screenX, float screenY);
    
    public abstract void render();
    
    public abstract void resize(int width, int height);
    
    public abstract void initialize();
    
    public abstract void cleanup();
    
    /**
     * Clean 3D city exploration service
     * Native OpenGL/Vulkan implementation
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}