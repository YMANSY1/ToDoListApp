package com.example.todolistapp.models

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.todolistapp.ui.theme.Typography

enum class ThemeMode {
    SYSTEM,
    LIGHT,
    DARK
}

@Composable
fun ToDoListTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    content: @Composable () -> Unit
){
    val isDarkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme(),
        typography = Typography,
        content = content
    )
}

fun String.toThemeMode(): ThemeMode{
    return when(this){
        "System"->ThemeMode.SYSTEM
        "Light"->ThemeMode.LIGHT
        "Dark"->ThemeMode.DARK
        else -> ThemeMode.SYSTEM
    }
}
fun ThemeMode.toDisplayName(): String {
    return when (this) {
        ThemeMode.SYSTEM -> "System"
        ThemeMode.LIGHT -> "Light"
        ThemeMode.DARK -> "Dark"
    }
}