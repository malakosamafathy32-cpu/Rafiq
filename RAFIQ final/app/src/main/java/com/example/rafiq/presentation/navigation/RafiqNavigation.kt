package com.example.rafiq.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rafiq.presentation.home.HomeScreen
import com.example.rafiq.presentation.map.MapScreen
import com.example.rafiq.presentation.settings.SettingsScreen
import com.example.rafiq.presentation.voice.VoiceScreen

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Map : Screen("map_screen")
    object Voice : Screen("voice_screen")
    object Settings : Screen("settings_screen")
    object AddPlace : Screen("add_place_screen")
    object BeMyEyes : Screen("be_my_eyes_screen")
    object SOS : Screen("sos_screen")
    object Learning : Screen("learning_screen")
    object Awareness : Screen("awareness_screen")
    object Hospital : Screen("hospital_screen")
}

@Composable
fun RafiqNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Map.route) {
            MapScreen(navController = navController)
        }
        composable(Screen.Voice.route) {
            VoiceScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(Screen.AddPlace.route) {
            com.example.rafiq.presentation.gamification.AddPlaceScreen(navController = navController)
        }
        composable(Screen.BeMyEyes.route) {
            com.example.rafiq.presentation.bemyeyes.BeMyEyesScreen(navController = navController)
        }
        composable(Screen.SOS.route) {
            com.example.rafiq.presentation.sos.SosScreen(navController = navController)
        }
        composable(Screen.Learning.route) {
            com.example.rafiq.presentation.learning.LearningScreen(navController = navController)
        }
        composable(Screen.Awareness.route) {
            com.example.rafiq.presentation.awareness.AwarenessScreen(navController = navController)
        }
        composable(Screen.Hospital.route) {
            com.example.rafiq.presentation.hospital.HospitalScreen(navController = navController)
        }
    }
}
