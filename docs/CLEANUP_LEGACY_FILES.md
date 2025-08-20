# 🧹 Legacy Web App Cleanup Guide

## Files to Remove for Clean Native Android App

### ❌ **Web App Legacy Files (Safe to Delete):**
```
capacitor.config.ts          # Capacitor hybrid framework config
android/                     # Old Capacitor Android project
package.json                 # Node.js dependencies  
package-lock.json            # Node.js lock file
src/                         # React/TypeScript web app source
public/                      # Web app assets
index.html                   # Web app entry point
vite.config.ts              # Vite bundler configuration
tsconfig.*.json             # TypeScript configurations
tailwind.config.js          # CSS framework config
postcss.config.js           # CSS processor config  
eslint.config.js            # Web linting configuration
.nvmrc                      # Node version manager config
node_modules/               # Node.js dependencies folder
.next/                      # Next.js build cache
.bolt/                      # Bolt framework cache
```

### ✅ **Keep for Native Android App:**
```
android-native/             # Your clean native Android project
*.md files                  # Documentation and guides
.git/                       # Version control
.gitignore                 # Git ignore rules
*.sql files                # Database setup scripts (optional)
*.js database scripts      # Data migration scripts (optional)
```

## 🚀 **After Cleanup:**

Your project structure will be:
```
TuriPhone-Native/
├── android-native/         # Clean native Android app
├── docs/                   # All your .md documentation  
├── database/               # SQL scripts (optional)
└── .git/                   # Version control
```

**Result: Clean, focused native Android project with no web app legacy!**