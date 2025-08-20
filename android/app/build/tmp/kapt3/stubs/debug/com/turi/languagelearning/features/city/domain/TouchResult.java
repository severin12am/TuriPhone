package com.turi.languagelearning.features.city.domain;

import com.turi.languagelearning.features.conversation.domain.Character;

/**
 * Touch interaction result
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/TouchResult;", "", "()V", "CharacterTapped", "GroundTapped", "None", "ObjectTapped", "Lcom/turi/languagelearning/features/city/domain/TouchResult$CharacterTapped;", "Lcom/turi/languagelearning/features/city/domain/TouchResult$GroundTapped;", "Lcom/turi/languagelearning/features/city/domain/TouchResult$None;", "Lcom/turi/languagelearning/features/city/domain/TouchResult$ObjectTapped;", "app_debug"})
public abstract class TouchResult {
    
    private TouchResult() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/TouchResult$CharacterTapped;", "Lcom/turi/languagelearning/features/city/domain/TouchResult;", "character", "Lcom/turi/languagelearning/features/conversation/domain/Character;", "(Lcom/turi/languagelearning/features/conversation/domain/Character;)V", "getCharacter", "()Lcom/turi/languagelearning/features/conversation/domain/Character;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class CharacterTapped extends com.turi.languagelearning.features.city.domain.TouchResult {
        @org.jetbrains.annotations.NotNull()
        private final com.turi.languagelearning.features.conversation.domain.Character character = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.conversation.domain.Character component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.TouchResult.CharacterTapped copy(@org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.conversation.domain.Character character) {
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
        
        public CharacterTapped(@org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.conversation.domain.Character character) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.conversation.domain.Character getCharacter() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/TouchResult$GroundTapped;", "Lcom/turi/languagelearning/features/city/domain/TouchResult;", "position", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "(Lcom/turi/languagelearning/features/city/domain/Vector3;)V", "getPosition", "()Lcom/turi/languagelearning/features/city/domain/Vector3;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class GroundTapped extends com.turi.languagelearning.features.city.domain.TouchResult {
        @org.jetbrains.annotations.NotNull()
        private final com.turi.languagelearning.features.city.domain.Vector3 position = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.Vector3 component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.TouchResult.GroundTapped copy(@org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.city.domain.Vector3 position) {
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
        
        public GroundTapped(@org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.city.domain.Vector3 position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.Vector3 getPosition() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/TouchResult$None;", "Lcom/turi/languagelearning/features/city/domain/TouchResult;", "()V", "app_debug"})
    public static final class None extends com.turi.languagelearning.features.city.domain.TouchResult {
        @org.jetbrains.annotations.NotNull()
        public static final com.turi.languagelearning.features.city.domain.TouchResult.None INSTANCE = null;
        
        private None() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/turi/languagelearning/features/city/domain/TouchResult$ObjectTapped;", "Lcom/turi/languagelearning/features/city/domain/TouchResult;", "objectId", "", "position", "Lcom/turi/languagelearning/features/city/domain/Vector3;", "(Ljava/lang/String;Lcom/turi/languagelearning/features/city/domain/Vector3;)V", "getObjectId", "()Ljava/lang/String;", "getPosition", "()Lcom/turi/languagelearning/features/city/domain/Vector3;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class ObjectTapped extends com.turi.languagelearning.features.city.domain.TouchResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String objectId = null;
        @org.jetbrains.annotations.NotNull()
        private final com.turi.languagelearning.features.city.domain.Vector3 position = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.Vector3 component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.TouchResult.ObjectTapped copy(@org.jetbrains.annotations.NotNull()
        java.lang.String objectId, @org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.city.domain.Vector3 position) {
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
        
        public ObjectTapped(@org.jetbrains.annotations.NotNull()
        java.lang.String objectId, @org.jetbrains.annotations.NotNull()
        com.turi.languagelearning.features.city.domain.Vector3 position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getObjectId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.turi.languagelearning.features.city.domain.Vector3 getPosition() {
            return null;
        }
    }
}