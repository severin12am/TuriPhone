package com.turi.languagelearning.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val email: String?,
    val motherLanguage: String,
    val targetLanguage: String,
    val totalMinutes: Int = 0,
    val isAuthenticated: Boolean = false,
    val lastSyncTime: Long = 0L
)