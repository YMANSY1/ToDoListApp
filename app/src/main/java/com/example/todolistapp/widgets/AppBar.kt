package com.example.todolistapp.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar(navController: NavHostController, isSettings: Boolean = false) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isSettings) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow back"
                        )
                    }
                }
                Text(
                    modifier = Modifier.weight(1f),
                    text = if (isSettings)
                        "Settings"
                    else "To Do List"

                )
                if (!isSettings) IconButton(
                    onClick = { navController.navigate("settings") }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "go to settings"
                    )
                }
            }
        }
    )
}