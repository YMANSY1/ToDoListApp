package com.example.todolistapp.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonWithIcon(
    onClick: ()->Unit,
    text: String,
    icon: ImageVector,
    containerColor: Color,
    contentColor: Color,
    radius: Dp = 20.dp,
    padding: Dp =0.dp
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor, // Soft Sage Green
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(12.dp),
        shape = RoundedCornerShape(radius)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "add task"
            )
            Text(text)
        }
    }
}