# Turi Language Learning App - Codebase Overview

## Project Summary
Turi is a 3D language learning application built as a web app using React, Three.js, and Capacitor for mobile deployment. The app features an immersive 3D city environment where users interact with characters to practice conversations in their target language.

## Technology Stack

### Frontend Framework
- **React 18.3.1** with TypeScript
- **Vite** as build tool and dev server
- **Three.js** for 3D graphics
- **@react-three/fiber** & **@react-three/drei** for React-Three.js integration
- **Tailwind CSS** for styling
- **Zustand** for state management

### Mobile Platform
- **Capacitor 5.6.0** for native mobile app deployment
- **Android SDK** configured for Android deployment
- Native plugins: App, Haptics, Screen Orientation, Splash Screen, Status Bar

### Backend & Services
- **Supabase** for authentication and database
- **Google Gemini AI** for AI-powered dialogues and word explanations
- **PostgreSQL** database via Supabase

### Build & Development
- **ESLint** for code linting
- **PostCSS** & **Autoprefixer** for CSS processing
- **TypeScript** for type safety

## Application Architecture

### Entry Points
- **`src/main.tsx`** - Application entry point, initializes React and exposes global objects
- **`src/App.tsx`** - Main application component with authentication and scene management
- **`index.html`** - HTML entry point

### State Management (`src/store/index.ts`)
Uses Zustand for centralized state management:
- **User State**: Authentication, user profile, language preferences
- **UI State**: Dialog visibility, quiz state, helper robot status
- **Game State**: Language levels, progress tracking, movement controls
- **Instructions State**: Helper robot guidance system

### Core Components

#### 3D Scene Components (`src/scenes/`)
- **`City.tsx`** (86KB) - Main 3D scene with city model, character management, player controls
- **`Character.tsx`** - Individual 3D character components with animations and interactions
- **`HelperRobotModel.tsx`** - 3D helper robot model

#### UI Components (`src/components/`)
- **`HelperRobot.tsx`** (20KB) - AI assistant with language selection and guidance
- **`HelperRobotPanel.tsx`** (21KB) - Progress tracking and user interface panel
- **`DialogueBox.tsx`** (128KB) - Main dialogue interface with speech recognition
- **`VocalQuizComponent.tsx`** (81KB) - Voice-based quiz system
- **`MobileControls.tsx`** (9.6KB) - Touch joystick controls for mobile
- **`AIDialogueModal.tsx`** - AI-powered conversation interface
- **`WordExplanationModal.tsx`** - Context-aware word explanations
- **`LoginForm.tsx`** - User authentication interface
- **Language Components**: `LanguagePanel.tsx`, `LanguageSelector.tsx`

#### Mobile-Specific Components
- **`MobileControls.tsx`** - Dual joystick system (movement + camera)
- **`MobileControls.css`** - Mobile-optimized styling
- **`useMobile.ts`** - Hook for mobile platform detection and initialization

### Services (`src/services/`)

#### Authentication (`auth.ts` - 30KB)
- Supabase integration for user registration/login
- Anonymous user support with localStorage fallback
- Session management and persistence
- Progress synchronization

#### AI Integration (`gemini.ts` - 18KB)
- Google Gemini API integration
- Rate limiting and error handling
- AI dialogue generation
- Word explanation generation
- Multi-model fallback system

#### Database (`supabase.ts` - 9.3KB)
- Database client configuration
- Security and validation layer
- Custom storage handlers for offline support

#### Progress Tracking (`progress.ts` - 17KB)
- User progress synchronization
- Word learning tracking
- Dialogue completion tracking
- Level advancement logic

#### Security (`security.ts` - 9.8KB)
- Input validation and sanitization
- Query security measures
- Cache management

#### Utilities
- **`logger.ts`** - Centralized logging system
- **`version.ts`** - Version tracking and history

### Type System (`src/types/index.ts`)
Comprehensive TypeScript definitions for:
- **User**: User profiles and authentication
- **Character**: 3D character data and positioning
- **Phrase**: Dialogue system data structures
- **WordExplanation**: AI-generated explanations
- **LanguageLevel**: Progress tracking
- **Instruction**: Helper system guidance

### Constants & Configuration

#### Language Support (`src/constants/`)
- **`languages.ts`** - 11 popular languages supported
- **`translations.ts`** - 100+ language translation system
- Extensive i18n infrastructure for UI elements

#### Mobile Configuration
- **`capacitor.config.ts`** - Capacitor configuration with landscape orientation
- **`android/`** - Native Android project structure
- **`useMobile.ts`** - Mobile platform detection and initialization

## Key Features

### 3D Interactive Environment
- **City Scene**: Large 3D city model with 30+ character positions
- **Character System**: Individual 3D models with animations and interactions
- **Player Movement**: WASD keyboard controls + mobile joystick controls
- **Camera System**: First-person perspective with mobile touch look controls

### Language Learning System
- **Multi-language Support**: 100+ languages with native name display
- **AI Dialogues**: Context-aware conversations powered by Google Gemini
- **Voice Recognition**: Speech-to-text for pronunciation practice
- **Word Explanations**: Context-sensitive vocabulary help
- **Progress Tracking**: Persistent learning progress across sessions

### Mobile Optimization
- **Touch Controls**: Dual joystick system for movement and camera
- **Orientation Lock**: Landscape mode for optimal experience
- **Responsive UI**: Mobile-adapted interface components
- **Native Integration**: Capacitor plugins for native mobile features

### User Experience
- **Helper Robot**: AI guide for navigation and instructions
- **Authentication**: Optional account creation with anonymous mode
- **Offline Support**: localStorage fallback for core functionality
- **Progress Visualization**: Visual progress tracking and statistics

## Mobile Readiness Assessment

### ✅ Already Mobile-Ready
1. **Capacitor Integration**: Fully configured for Android deployment
2. **Touch Controls**: Complete joystick system for mobile interaction
3. **Responsive Design**: Mobile-optimized UI components
4. **Native Features**: Status bar, splash screen, orientation lock
5. **Offline Support**: localStorage fallback for core functionality

### 🔧 Areas for Mobile Enhancement
1. **Performance**: 3D scene optimization for mobile GPUs
2. **Battery Life**: Rendering optimization and frame rate management
3. **Storage**: Efficient asset loading and caching
4. **Network**: Offline mode improvements
5. **UX**: Mobile-specific interaction patterns

## Development Workflow

### Scripts Available
- `npm run dev` - Development server
- `npm run build` - Production build
- `npm run mobile:build` - Build for mobile deployment
- `npm run mobile:sync` - Sync with Capacitor
- `npm run mobile:run` - Run on Android device
- `npm run mobile:open` - Open Android Studio

### Database Setup Scripts
- Character data initialization
- Dialogue data setup
- User progress table creation
- RLS (Row Level Security) management scripts

## Security Considerations
- Input validation and sanitization
- Supabase RLS policies
- API key management
- User data protection
- Session security

## File Structure Summary
```
├── src/
│   ├── components/     # React UI components (22 files)
│   ├── scenes/         # 3D scene components (3 files)  
│   ├── services/       # Backend integrations (7 files)
│   ├── store/          # State management (1 file)
│   ├── types/          # TypeScript definitions (1 file)
│   ├── constants/      # Language and translations (2 files)
│   ├── hooks/          # React hooks (1 file)
│   └── prompts/        # AI prompt templates (1 file)
├── android/            # Native Android project
├── public/models/      # 3D model assets (30+ GLB files)
└── Configuration files # Package.json, Capacitor, etc.
```

## Next Steps for Mobile Development
1. **Performance Testing**: Test 3D performance on various mobile devices
2. **Asset Optimization**: Compress 3D models and textures for mobile
3. **Battery Optimization**: Implement frame rate limiting and power management
4. **Platform-Specific Features**: Add Android-specific enhancements
5. **App Store Preparation**: Icons, screenshots, and store listings
6. **Testing**: Comprehensive testing on various Android devices and versions

The codebase is well-structured and already includes significant mobile optimizations, making the transition to a native mobile app straightforward with Capacitor.