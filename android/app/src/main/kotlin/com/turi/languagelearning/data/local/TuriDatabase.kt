package com.turi.languagelearning.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.turi.languagelearning.data.local.dao.UserDao
import com.turi.languagelearning.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TuriDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}