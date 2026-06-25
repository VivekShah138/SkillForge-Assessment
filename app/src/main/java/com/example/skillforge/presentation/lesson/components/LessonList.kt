package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.utils.dummyLessons

@Composable
fun LessonList(
    lessons: List<LessonModel>
) {
    LazyColumn {
        items(lessons) { lesson ->
            LessonRow(
                lesson = lesson,
                lessonId = dummyLessons[0].id
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonListPreview() {
    LessonList(
        dummyLessons
    )
}