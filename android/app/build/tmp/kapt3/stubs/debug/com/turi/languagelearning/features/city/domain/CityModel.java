package com.turi.languagelearning.features.city.domain;

import com.turi.languagelearning.features.conversation.domain.Character;

/**
 * City model data
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\fH\u00c6\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/CityModel;", "", "id", "", "name", "modelPath", "spawnPoints", "", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "characterPositions", "", "boundaries", "Lcom/turi/languagelearning/features/city/domain/CityBoundaries;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/turi/languagelearning/features/city/domain/CityBoundaries;)V", "getBoundaries", "()Lcom/turi/languagelearning/features/city/domain/CityBoundaries;", "getCharacterPositions", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getModelPath", "getName", "getSpawnPoints", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class CityModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modelPath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.turi.languagelearning.features.city.domain.Vector3> spawnPoints = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.turi.languagelearning.features.city.domain.Vector3> characterPositions = null;
    @org.jetbrains.annotations.NotNull()
    private final com.turi.languagelearning.features.city.domain.CityBoundaries boundaries = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.features.city.domain.Vector3> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.turi.languagelearning.features.city.domain.Vector3> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.CityBoundaries component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.CityModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String modelPath, @org.jetbrains.annotations.NotNull()
    java.util.List<com.turi.languagelearning.features.city.domain.Vector3> spawnPoints, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.turi.languagelearning.features.city.domain.Vector3> characterPositions, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.CityBoundaries boundaries) {
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
    
    public CityModel(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String modelPath, @org.jetbrains.annotations.NotNull()
    java.util.List<com.turi.languagelearning.features.city.domain.Vector3> spawnPoints, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.turi.languagelearning.features.city.domain.Vector3> characterPositions, @org.jetbrains.annotations.NotNull()
    com.turi.languagelearning.features.city.domain.CityBoundaries boundaries) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.turi.languagelearning.features.city.domain.Vector3> getSpawnPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.turi.languagelearning.features.city.domain.Vector3> getCharacterPositions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.turi.languagelearning.features.city.domain.CityBoundaries getBoundaries() {
        return null;
    }
}