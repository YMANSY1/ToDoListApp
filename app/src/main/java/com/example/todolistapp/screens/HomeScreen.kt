package com.example.todolistapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.todolistapp.models.TaskRepository.removeCompletedTasks
import com.example.todolistapp.models.TaskRepository.tasks
import com.example.todolistapp.widgets.AppBar
import com.example.todolistapp.widgets.ButtonWithIcon
import com.example.todolistapp.widgets.NewTaskDialog
import com.example.todolistapp.widgets.TaskListView

@Composable
fun HomeScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = { AppBar(navController = navController) }
    ) {innerPadding->
        Column(Modifier.padding(innerPadding)) {
            ButtonWithIcon(
                onClick = { showDialog = true },
                text = "Add Task",
                icon = Icons.Filled.Add,
                containerColor = Color(0xFFA8CABA),
                contentColor = Color(0xFF333333),
                padding = 8.dp
            )
            if (showDialog) {
                NewTaskDialog(
                    onDismiss = { showDialog = false }
                )
            }
            if (tasks.isNotEmpty()) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    TaskListView()
                }
                ButtonWithIcon(
                    onClick = { removeCompletedTasks() },
                    text = "Delete All Complete Tasks",
                    icon = Icons.Filled.Delete,
                    containerColor = Color(0xFFD2481D), // Soft Sage Green
                    contentColor = Color.White,
                    radius = 8.dp,
                    padding = 4.dp
                )
            } else {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) { Text("All tasks complete, Add a new task!") }
            }


        }
    }
}



