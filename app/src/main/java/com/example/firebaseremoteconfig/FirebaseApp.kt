package com.example.firebaseremoteconfig

import android.app.Application
import com.google.firebase.FirebaseApp

class FirebaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}