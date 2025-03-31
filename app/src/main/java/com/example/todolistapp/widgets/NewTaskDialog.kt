package com.example.todolistapp.widgets

import android.content.Context
import android.util.Log.e
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.models.TaskRepository
import com.example.todolistapp.models.TaskRepository.dialogToTask
import com.example.todolistapp.models.TaskRepository.tasks


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NewTaskDialog(
    context: Context = LocalContext.current,
    onDismiss: ()->Unit,
) {
    var taskEntry by remember { mutableStateOf("") }
    var descriptionEntry by remember { mutableStateOf("") }
    BasicAlertDialog(onDismissRequest = onDismiss,
        content = {
            Card(
                modifier = Modifier
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Add New Task",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    OutlinedTextField(
                        value = taskEntry,
                        label = { Text("Task Name") },
                        onValueChange = { taskEntry = it },
                    )
                    OutlinedTextField(
                        value = descriptionEntry,
                        label = { Text("Task Description (Optional)") },
                        onValueChange = { descriptionEntry = it },
                    )
                    Row(modifier = Modifier.align(Alignment.End)) {
                        TextButton(
                            onClick = onDismiss
                        ) { Text("Cancel") }
                        TextButton(
                            onClick = {
                                if (taskEntry.isBlank()) {
                                    Toast.makeText(
                                        context,
                                        "Please specify a task name",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@TextButton
                                }

                                val task = dialogToTask(
                                    taskName = taskEntry,
                                    description = descriptionEntry.ifBlank { null }
                                )

                                TaskRepository.addTask(task)
                                e(
                                    "TAG",
                                    "Task List: $tasks"
                                )

                                taskEntry = ""
                                descriptionEntry= ""

                                onDismiss()
                            }
                        ) { Text("Save") }

                    }
                }
            }
        })
}