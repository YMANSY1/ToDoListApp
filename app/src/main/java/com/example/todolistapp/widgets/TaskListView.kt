package com.example.todolistapp.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todolistapp.models.TaskRepository.tasks

@Composable
fun TaskListView() {
    LazyColumn {
        items(tasks) { task ->
            TaskCard(task)
        }

    }
}
