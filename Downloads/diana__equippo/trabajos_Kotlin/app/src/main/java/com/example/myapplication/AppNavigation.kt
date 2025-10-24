package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Importamos las pantallas desde la carpeta "screens"
import com.example.myapplication.screens.CoroutinesScreen
import com.example.myapplication.screens.DashboardScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // El NavHost es el "escenario"
    NavHost(navController = navController, startDestination = "dashboard") {

        // Ruta 1: "dashboard"
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }

        // Ruta 2: "coroutines_view"
        composable("coroutines_view") {
            CoroutinesScreen()
        }
    }
}