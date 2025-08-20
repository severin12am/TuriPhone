package com.turi.languagelearning

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp // Temporarily disabled
class TuriApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize any global configurations here
        // This is where we'll set up logging, crash reporting, etc.
    }
}