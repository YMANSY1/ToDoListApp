package com.example.todolistapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolistapp.models.ThemeMode
import com.example.todolistapp.screens.HomeScreen
import com.example.todolistapp.screens.SettingsScreen

@Composable
fun AppNavigation(navController: NavHostController, themeMode: ThemeMode, onThemeChange: (ThemeMode) -> Unit) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") { HomeScreen(navController) }
        composable(route = "settings") { SettingsScreen(navController, themeMode, onThemeChange) }
    }
}
