package com.example.firebaseremoteconfig

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.firebase.remoteconfig.remoteConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

object RemoteConfigHelper {
    private val remoteConfig = Firebase.remoteConfig
    private val settings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 3600
    }

    fun initDefaults() {
        val defaults = mapOf(
            "feature_enabled" to false
        )
        remoteConfig.setDefaultsAsync(defaults)
        remoteConfig.setConfigSettingsAsync(settings)
    }

    suspend fun fetchAndActivate(): Boolean = withContext(Dispatchers.IO) {
        try {
            remoteConfig.fetchAndActivate().await()
        } catch (e: Exception) {
            false
        }
    }

    fun isFeatureEnabled(): Boolean {
        return remoteConfig.getBoolean("feature_enabled")
    }
}
