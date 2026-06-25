package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.utils.dummyLessons

@Composable
fun LessonDetailsSection(
    lessonModel: LessonModel
) {
    Column {
        Text(
            text = formatLesson(1,"Kotlin Fundamentals"),
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color(0xFF00B8A9),
                fontWeight = FontWeight.Bold
            ),
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = lessonModel.title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = lessonModel.content,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonDetailsPreview() {
    LessonDetailsSection(
        lessonModel = dummyLessons[0]
    )
}

fun formatLesson(index: Int, courseName: String): String {
    return "LESSON ${index + 1}: $courseName"
}