package com.example.rafiq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.rafiq.data.local.UserPreferences
import com.example.rafiq.presentation.navigation.RafiqNavigation
import com.example.rafiq.ui.theme.RAFIQTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userPreferences = UserPreferences(applicationContext)
        setContent {
            val darkThemePref by userPreferences.darkTheme.collectAsState(initial = "system")
            val fontSizePref by userPreferences.fontSize.collectAsState(initial = "normal")
            val fontFamilyPref by userPreferences.fontFamily.collectAsState(initial = "default")
            val useDarkTheme = when (darkThemePref) {
                "dark" -> true
                "light" -> false
                else -> isSystemInDarkTheme()
            }
            RAFIQTheme(darkTheme = useDarkTheme, fontSize = fontSizePref, fontFamily = fontFamilyPref) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RafiqNavigation()
                }
            }
        }
    }
}
