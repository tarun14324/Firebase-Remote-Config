# 📱 Firebase Remote Config Integration - Android

This Android project demonstrates the integration of Firebase Remote Config using Kotlin. It supports both Jetpack Compose and traditional View-based UI.

---

## 👤 Project Owner

Name: Lanka Tarun 
Role: Android Developer  
Email: tarunlanka7@.com  
GitHub: https://github.com/tarun14324  
LinkedIn: https://www.linkedin.com/in/tarun-lanka/  

---

## 📂 Project Details

- Project Name: Firebase Remote Config Demo
- Tech Stack: Kotlin, Firebase, Jetpack Compose / XML, MVVM (optional)
- Minimum SDK: 21
- Target SDK: 34
- Build Tool: Gradle (Kotlin DSL / Groovy)
- Firebase Features Used: 
  - Remote Config  
  - Firebase Core / Analytics (optional)

---

## 🔧 Prerequisites

- Android Studio
- Firebase Console access
- Firebase project and app registered
- `google-services.json` added to `app/` directory

---

## 📦 Dependencies

<details>
<summary>Click to expand Gradle config</summary>

### Project-level `build.gradle`:

```gradle
classpath 'com.google.gms:google-services:4.4.1'

### App-level `build.gradle`:

-Dependecies
  implementation platform('com.google.firebase:firebase-bom:32.7.2')
  implementation 'com.google.firebase:firebase-config-ktx'

