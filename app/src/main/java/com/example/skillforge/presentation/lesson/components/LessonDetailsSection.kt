package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LessonDetailsSection() {
    Column {
        Text(
            "LESSON 1 · KOTLIN FUNDAMENTALS",
            color = Color(0xFF00B8A9),
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "Welcome & Setup",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "Set up Android Studio and run your first Kotlin file.",
            color = Color.Gray,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonDetailsPreview() {
    LessonDetailsSection()
}