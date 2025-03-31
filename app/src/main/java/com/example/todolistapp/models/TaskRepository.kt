package com.example.todolistapp.models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object TaskRepository {
    val tasks = mutableStateListOf<Task>()

    fun addTask(task: Task) = tasks.add(
        0,
        task
    )

    fun dialogToTask(taskName: String, description: String? = ""): Task = Task(
        taskName = taskName,
        taskDescription = description
    )

    fun removeTask(task: Task) = tasks.remove(task)
    fun removeCompletedTasks() = tasks.removeAll { it.isComplete.value }
}