package com.turi.languagelearning.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    val id: String,
    val email: String?,
    val motherLanguage: String,
    val targetLanguage: String,
    val totalMinutes: Int = 0,
    val isAuthenticated: Boolean = false
) : Parcelable

@Parcelize
data class LanguageLevel(
    val id: String,
    val userId: String,
    val motherLanguage: String,
    val targetLanguage: String,
    val level: Int,
    val dialogueNumber: Int? = null,
    val wordProgress: Int,
    val email: String
) : Parcelable

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val role: String,
    val positionX: Float,
    val positionY: Float,
    val positionZ: Float,
    val scaleX: Float,
    val scaleY: Float,
    val scaleZ: Float,
    val rotationY: Float? = null,
    val isActive: Boolean
) : Parcelable

@Parcelize
data class Phrase(
    val id: Int,
    val dialogueId: Int,
    val characterId: Int,
    val text: String,
    val audioUrl: String? = null,
    val order: Int
) : Parcelable

@Parcelize
data class WordExplanation(
    val id: Int,
    val word: String,
    val explanation: String,
    val language: String
) : Parcelable