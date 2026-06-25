package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CourseContentHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Course content",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Text(
            "3 lessons · 41 min",
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CourseContentHeader()
}