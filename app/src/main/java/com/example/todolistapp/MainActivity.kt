package com.example.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.models.ThemeMode
import com.example.todolistapp.models.ToDoListTheme
import com.example.todolistapp.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController()
            var themeMode by remember { mutableStateOf(ThemeMode.LIGHT) }
            ToDoListTheme(themeMode = themeMode) {
                AppNavigation(navController, themeMode) { newTheme ->
                    themeMode = newTheme
                }
            }
        }
    }
}
