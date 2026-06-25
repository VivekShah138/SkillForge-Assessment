package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LessonTabs() {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text("Lessons", fontWeight = FontWeight.Bold)
            Text("Notes", color = Color.Gray)
            Text("Resources", color = Color.Gray)
        }

        Spacer(Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(55.dp)
                .height(3.dp)
                .background(Color(0xFF00B8A9))
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TabsPreview() {
    LessonTabs()
}
