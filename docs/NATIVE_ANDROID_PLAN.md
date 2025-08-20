# Native Android Development Plan for Turi Language Learning

## Executive Summary
Convert the React/Three.js web app to a native Android application using Kotlin, Jetpack Compose, and Vulkan for optimal performance and user experience.

## Technology Stack

### Core Technologies
- **Language**: Kotlin (100% native)
- **UI Framework**: Jetpack Compose
- **3D Graphics**: Vulkan API (Google's 2025 official recommendation)
- **Architecture**: MVVM + Repository Pattern
- **Dependency Injection**: Hilt
- **Async Processing**: Coroutines + Flow

### Key Libraries
```kotlin
// UI & Navigation
implementation "androidx.compose.ui:ui:$compose_version"
implementation "androidx.navigation:navigation-compose:$nav_version"
implementation "androidx.activity:activity-compose:$activity_version"

// 3D Graphics
implementation "org.rajawali3d:rajawali:$rajawali_version" // Alternative to raw Vulkan
// Or direct Vulkan NDK implementation

// Networking & Backend
implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation "io.github.jan-tennert.supabase:postgrest-kt:$supabase_version"
implementation "io.github.jan-tennert.supabase:auth-kt:$supabase_version"

// Audio & Speech
implementation "androidx.media3:media3-exoplayer:$media3_version"
implementation "com.google.android.gms:play-services-mlkit-text-recognition:$mlkit_version"

// Local Storage
implementation "androidx.room:room-runtime:$room_version"
implementation "androidx.room:room-ktx:$room_version"
```

## Project Structure

```
app/
├── src/main/kotlin/com/turi/languagelearning/
│   ├── data/
│   │   ├── local/          # Room database
│   │   ├── remote/         # API services
│   │   └── repository/     # Data repositories
│   ├── domain/
│   │   ├── model/          # Data models
│   │   ├── repository/     # Repository interfaces
│   │   └── usecase/        # Business logic
│   ├── presentation/
│   │   ├── ui/
│   │   │   ├── auth/       # Login/signup screens
│   │   │   ├── language/   # Language selection
│   │   │   ├── game/       # 3D game scene
│   │   │   ├── dialogue/   # Conversation screens
│   │   │   └── progress/   # Progress tracking
│   │   └── viewmodel/      # ViewModels
│   ├── core/
│   │   ├── graphics/       # Vulkan rendering engine
│   │   ├── audio/          # Audio processing
│   │   └── utils/          # Common utilities
│   └── di/                 # Dependency injection
└── src/main/cpp/           # Native C++ for Vulkan
    ├── vulkan/             # Vulkan rendering
    ├── models/             # 3D model loading
    └── shaders/            # GLSL shaders
```

## Implementation Plan

### Phase 1: Foundation Setup (Week 1-2)

#### Week 1: Project Setup
- [ ] Create new Android Studio project with Kotlin
- [ ] Set up Jetpack Compose and navigation
- [ ] Configure Hilt for dependency injection
- [ ] Set up build variants and signing configs
- [ ] Create basic project structure

#### Week 2: Authentication & Backend
- [ ] Implement Supabase SDK integration
- [ ] Create authentication screens (Login/Signup)
- [ ] Set up Repository pattern for data layer
- [ ] Implement user session management
- [ ] Create basic navigation between screens

### Phase 2: 3D Graphics Engine (Week 3-5)

#### Week 3: Vulkan Setup
- [ ] Set up Vulkan NDK integration
- [ ] Create basic Vulkan renderer class
- [ ] Implement surface creation and swap chain
- [ ] Set up shader compilation pipeline
- [ ] Create basic triangle rendering test

#### Week 4: 3D Model Loading
- [ ] Implement GLB/GLTF model loader
- [ ] Convert existing city.glb model
- [ ] Set up character model loading system
- [ ] Implement basic camera controls
- [ ] Add model positioning and scaling

#### Week 5: Scene Management
- [ ] Create 3D scene graph system
- [ ] Implement character interaction system
- [ ] Add touch controls for movement
- [ ] Set up collision detection
- [ ] Optimize rendering performance

### Phase 3: Core Features (Week 6-8)

#### Week 6: Dialogue System
- [ ] Create dialogue UI components
- [ ] Implement speech-to-text integration
- [ ] Set up text-to-speech for characters
- [ ] Create dialogue state management
- [ ] Add word highlighting and explanations

#### Week 7: AI Integration
- [ ] Integrate Google Gemini API
- [ ] Implement AI dialogue generation
- [ ] Create word explanation system
- [ ] Set up context-aware conversations
- [ ] Add error handling and fallbacks

#### Week 8: Progress System
- [ ] Implement Room database for local storage
- [ ] Create progress tracking system
- [ ] Set up level advancement logic
- [ ] Add statistics and analytics
- [ ] Implement offline mode support

### Phase 4: Advanced Features (Week 9-10)

#### Week 9: Audio & Voice
- [ ] Implement audio playback system
- [ ] Add voice recognition for pronunciation
- [ ] Create audio feedback system
- [ ] Set up background music and sound effects
- [ ] Optimize audio performance

#### Week 10: UI Polish & UX
- [ ] Refine Compose UI components
- [ ] Add animations and transitions
- [ ] Implement material design guidelines
- [ ] Add accessibility features
- [ ] Create responsive layouts for tablets

### Phase 5: Testing & Optimization (Week 11-12)

#### Week 11: Performance & Testing
- [ ] Performance profiling and optimization
- [ ] Memory leak detection and fixes
- [ ] Battery usage optimization
- [ ] Unit and integration testing
- [ ] Device compatibility testing

#### Week 12: Release Preparation
- [ ] Create app icons and screenshots
- [ ] Write Play Store listing
- [ ] Set up crash reporting (Firebase)
- [ ] Final bug fixes and polish
- [ ] Prepare release APK/AAB

## Key Migration Mappings

### State Management
```kotlin
// Web (Zustand) → Android (ViewModel + StateFlow)
class GameViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()
    
    private val _isLanguageSelected = MutableStateFlow(false)
    val isLanguageSelected = _isLanguageSelected.asStateFlow()
}
```

### Component Architecture
```kotlin
// Web (React Component) → Android (Compose Component)
@Composable
fun LanguageSelector(
    onLanguageSelect: (mother: String, target: String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Jetpack Compose UI implementation
}
```

### 3D Rendering
```cpp
// Web (Three.js) → Android (Vulkan)
class VulkanRenderer {
    void initVulkan();
    void loadModel(const std::string& path);
    void render();
    void cleanup();
};
```

## Data Migration Strategy

### Database Schema
- Keep existing Supabase schema unchanged
- Create Room entities matching Supabase tables
- Implement sync mechanism between local and remote data

### Asset Migration
- Convert GLB models to optimized Android formats
- Compress textures for mobile GPUs
- Create multiple resolution variants

### API Integration
- Maintain existing Supabase endpoints
- Keep Gemini AI integration patterns
- Add offline caching layer

## Performance Considerations

### 3D Graphics Optimization
- Use Vulkan for maximum GPU performance
- Implement frustum culling and LOD systems
- Optimize shader compilation and caching
- Use GPU profiling tools for optimization

### Memory Management
- Implement proper texture streaming
- Use object pooling for frequent allocations
- Monitor memory usage with profilers
- Implement background memory cleanup

### Battery Life
- Implement frame rate limiting
- Use ADPF (Android Dynamic Performance Framework)
- Optimize CPU usage in background
- Implement power-aware rendering modes

## Testing Strategy

### Unit Testing
- Repository layer testing
- ViewModel logic testing
- Use case testing
- Utility function testing

### Integration Testing
- Database operations
- API integration
- Audio system testing
- 3D rendering pipeline

### UI Testing
- Compose UI testing
- Navigation testing
- User interaction flows
- Accessibility testing

### Device Testing
- Multiple screen sizes and densities
- Different Android versions (API 24+)
- Various GPU capabilities
- Performance on low-end devices

## Deployment Strategy

### Build Configuration
- Separate debug/release configurations
- ProGuard/R8 optimization for release
- Multiple APK generation for different architectures
- App bundle optimization

### Play Store Preparation
- Create compelling app listing
- Generate high-quality screenshots
- Write engaging app description
- Set up staged rollout plan

### Monitoring & Analytics
- Firebase Crashlytics for crash reporting
- Performance monitoring
- User engagement analytics
- A/B testing for feature improvements

## Risk Mitigation

### Technical Risks
- **Vulkan Complexity**: Have OpenGL ES fallback ready
- **Performance Issues**: Continuous profiling and optimization
- **Device Compatibility**: Extensive testing matrix
- **Memory Constraints**: Implement aggressive memory management

### Timeline Risks
- **3D Engine Complexity**: Consider using existing engines (Godot, Unity) if needed
- **Feature Creep**: Stick to MVP for first release
- **Testing Time**: Allocate sufficient time for device testing

### Business Risks
- **User Adoption**: Maintain feature parity with web version
- **App Store Approval**: Follow all guidelines strictly
- **Competition**: Focus on unique 3D learning experience

## Success Metrics

### Performance Targets
- App startup time < 3 seconds
- 60 FPS rendering on mid-range devices
- Memory usage < 200MB average
- Battery drain < 5% per 30-minute session

### Quality Targets
- Crash rate < 0.1%
- ANR rate < 0.05%
- 4.5+ star rating on Play Store
- 95%+ compatibility across target devices

## Conclusion

This native Android approach will deliver:
- **Superior Performance**: Native Kotlin + Vulkan optimization
- **Better User Experience**: Platform-native UI and interactions
- **Future-Proof**: Using latest Android technologies
- **Maintainable**: Clean architecture and modern patterns
- **Scalable**: Easy to add new features and improvements

The 12-week timeline is aggressive but achievable with focused development and proper prioritization. The key is to start with a solid foundation and incrementally build up the features while maintaining quality and performance standards.