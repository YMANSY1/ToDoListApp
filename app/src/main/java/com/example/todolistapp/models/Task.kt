package com.example.todolistapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Task(
    val taskName: String,
    val taskDescription: String? = null,
    val isComplete: MutableState<Boolean> = mutableStateOf(false)
)
