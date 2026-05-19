# Akshara-Deepa Tutor Android App

This is a Kotlin Android project for the Akshara-Deepa Tutor MVP described in `README (1).md`.

## Implemented

- Kotlin + Jetpack Compose app
- Room offline database
- Full preloaded question bank: 45 chapters and 225 MCQs
- Splash and first-launch welcome flow
- Mission Map dashboard
- Chapter list and chapter overview
- 5-question quiz flow with timer and next/previous navigation
- Result and answer review screens
- Gemini hint integration with offline fallback hints
- Strength map and progress history
- Daily WorkManager reminder notification
- Debug APK build verified

## Build

Use JDK 17. Because this project is inside OneDrive, redirect Gradle build output to avoid file-lock issues:

```powershell
$env:JAVA_HOME='C:\Program Files\Java\jdk-17'
$env:Path="$env:JAVA_HOME\bin;$env:Path"
$env:AKSHARA_BUILD_DIR='C:\Users\Anagha\AppData\Local\Temp\AksharaDeepaBuild'
.\gradlew.bat testDebugUnitTest
.\gradlew.bat assembleDebug
```

The verified debug APK was generated at:

```text
C:\Users\Anagha\AppData\Local\Temp\AksharaDeepaBuild\app\outputs\apk\debug\app-debug.apk
```

## Gemini API Key

Add this to `local.properties` for online AI hints:

```properties
GEMINI_API_KEY=your_gemini_api_key_here
```

If the key is empty, the app still works offline and shows local conceptual hints.
