package com.example.firebaseremoteconfig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.firebaseremoteconfig.ui.theme.FirebaseRemoteConfigTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseRemoteConfigTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FeatureToggleScreen( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FeatureToggleScreen(modifier:Modifier) {
    var isEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        RemoteConfigHelper.initDefaults()
        val fetched = RemoteConfigHelper.fetchAndActivate()
        if (fetched) {
            isEnabled = RemoteConfigHelper.isFeatureEnabled()
        }
    }

   Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
       if (isEnabled) {
           Text("🎉 Feature is enabled!")
       } else {
           Text("🚧 Feature is disabled.")
       }
   }
}
