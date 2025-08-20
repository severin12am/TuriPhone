# Clean Native Android App Architecture

## 🎯 Core Features Required
1. **3D City Exploration** - Walking around the city with touch controls
2. **Multi-Language TTS** - EN, RU, ES, AR, DE, JA, CH, FR (8 languages)
3. **Multi-Language Speech Recognition** - Same 8 languages
4. **Gemini AI Integration** - For conversations and explanations
5. **Supabase Integration** - Backend services and database
6. **Character Interactions** - Talk to characters in the city

## 🏗️ Clean Architecture Structure

```
app/
├── core/                           # Core utilities and base classes
│   ├── di/                        # Dependency injection (Hilt)
│   ├── database/                  # Room database + Supabase
│   ├── network/                   # API clients (Gemini, Supabase)
│   └── utils/                     # Common utilities
│
├── features/                      # Feature-based modules
│   ├── city/                      # 3D city exploration
│   │   ├── data/                  # 3D models, assets
│   │   ├── domain/                # City entities, use cases
│   │   └── presentation/          # City UI, ViewModels
│   │
│   ├── speech/                    # Speech services
│   │   ├── data/                  # TTS & Speech Recognition
│   │   ├── domain/                # Speech entities
│   │   └── presentation/          # Speech UI components
│   │
│   ├── conversation/              # Character conversations
│   │   ├── data/                  # Dialogue data, Gemini API
│   │   ├── domain/                # Conversation logic
│   │   └── presentation/          # Chat UI, ViewModels
│   │
│   └── profile/                   # User profile and progress
│       ├── data/                  # User data, Supabase
│       ├── domain/                # User entities
│       └── presentation/          # Profile UI
│
├── shared/                        # Shared components
│   ├── ui/                        # Reusable UI components
│   ├── navigation/                # App navigation
│   └── theme/                     # Design system
│
└── MainActivity.kt               # Single activity + Compose
```

## 🎯 Core Services Architecture

### **1. Speech Service (Clean)**
```kotlin
interface SpeechService {
    // TTS for 8 languages
    suspend fun speak(text: String, language: Language)
    
    // Speech Recognition for 8 languages  
    suspend fun listen(language: Language): String
    
    // Language management
    fun getSupportedLanguages(): List<Language>
    fun setCurrentLanguage(language: Language)
}
```

### **2. City Service (Native 3D)**
```kotlin
interface CityService {
    // 3D city management
    suspend fun loadCity(): CityModel
    suspend fun loadCharacters(): List<Character>
    
    // Player movement
    fun movePlayer(direction: Vector3)
    fun getPlayerPosition(): Vector3
    fun getNearbyCharacters(radius: Float): List<Character>
}
```

### **3. Conversation Service (AI-Powered)**
```kotlin
interface ConversationService {
    // Gemini AI integration
    suspend fun startConversation(character: Character, language: Language): Dialogue
    suspend fun continueConversation(userInput: String): Dialogue
    suspend fun explainWord(word: String, language: Language): Explanation
}
```

### **4. User Service (Supabase)**
```kotlin
interface UserService {
    // User management
    suspend fun signIn(email: String, password: String): User
    suspend fun signUp(email: String, password: String): User
    
    // Progress tracking
    suspend fun saveProgress(progress: LearningProgress)
    suspend fun getProgress(): LearningProgress
}
```

## 🌍 Language Support

### **Supported Languages (8 Total)**
```kotlin
enum class Language(val code: String, val displayName: String, val ttsLocale: String) {
    ENGLISH("en", "English", "en-US"),
    RUSSIAN("ru", "Русский", "ru-RU"), 
    SPANISH("es", "Español", "es-ES"),
    ARABIC("ar", "العربية", "ar-SA"),
    GERMAN("de", "Deutsch", "de-DE"),
    JAPANESE("ja", "日本語", "ja-JP"),
    CHINESE("zh", "中文", "zh-CN"),
    FRENCH("fr", "Français", "fr-FR")
}
```

## 🎮 App Flow (Simplified)

```
1. Launch → Language Selection
2. Sign In/Up (Supabase)
3. 3D City (Main Screen)
   ├── Walk around city
   ├── Find characters
   ├── Start conversations (Gemini AI)
   ├── Use TTS/Speech Recognition
   └── Track progress (Supabase)
```

## 📱 Technology Stack (Native-First)

### **Frontend**
- **UI**: Jetpack Compose (100% native)
- **3D Graphics**: Vulkan + OpenGL ES
- **Navigation**: Navigation Compose
- **State**: Compose State + ViewModels

### **Backend Services**
- **Database**: Room (local) + Supabase (cloud)
- **AI**: Google Gemini API
- **Auth**: Supabase Auth
- **TTS**: Android TextToSpeech API
- **Speech**: Android SpeechRecognizer API

### **Architecture**
- **Pattern**: Clean Architecture + MVVM
- **DI**: Hilt
- **Async**: Coroutines + Flow
- **Networking**: Retrofit + OkHttp

## 🧹 What We'll Remove

### **Legacy Web App Code**
- ❌ All React/Three.js references
- ❌ Capacitor integration
- ❌ Web-specific services
- ❌ Duplicate model classes
- ❌ Unused dependencies
- ❌ Web asset loading logic

### **Simplified Dependencies**
```kotlin
// ONLY essential native dependencies
dependencies {
    // Core Android
    implementation("androidx.core:core-ktx")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx")
    
    // Compose (Native UI)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.activity:activity-compose")
    
    // Navigation
    implementation("androidx.navigation:navigation-compose")
    
    // DI
    implementation("com.google.dagger:hilt-android")
    
    // Database
    implementation("androidx.room:room-runtime")
    implementation("androidx.room:room-ktx")
    
    // Network
    implementation("com.squareup.retrofit2:retrofit")
    implementation("com.squareup.okhttp3:okhttp")
    
    // Supabase
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:auth-kt")
    
    // 3D Graphics (Native)
    // OpenGL/Vulkan via NDK
}
```

## 🎯 Implementation Priority

1. **Core Architecture** - Clean project structure
2. **Speech Services** - TTS + Recognition for 8 languages  
3. **3D City** - Native city exploration
4. **Gemini Integration** - AI conversations
5. **Supabase Setup** - Backend services
6. **UI Polish** - Clean, native interface

This will give you a **clean, production-ready native Android app** with no legacy code and only the features you actually need!