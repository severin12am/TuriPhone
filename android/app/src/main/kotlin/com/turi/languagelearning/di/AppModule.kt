package com.turi.languagelearning.di

import android.content.Context
import androidx.room.Room
import com.turi.languagelearning.data.local.TuriDatabase
import com.turi.languagelearning.data.local.dao.UserDao
import com.turi.languagelearning.data.remote.SupabaseClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return SupabaseClient()
    }
    
    @Provides
    @Singleton
    fun provideTuriDatabase(
        @ApplicationContext context: Context
    ): TuriDatabase {
        return Room.databaseBuilder(
            context,
            TuriDatabase::class.java,
            "turi_database"
        )
        .fallbackToDestructiveMigration()
        .build()
    }
    
    @Provides
    fun provideUserDao(database: TuriDatabase): UserDao {
        return database.userDao()
    }
}