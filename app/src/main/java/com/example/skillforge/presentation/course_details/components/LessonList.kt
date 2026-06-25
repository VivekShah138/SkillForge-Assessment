package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.utils.dummyLessons


@Composable
fun LessonList(
    lessons: List<LessonModel>,
    onLessonClick: (lessonId: String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        lessons.forEach {
            LessonCard(
                it,
                onClick = {
                    onLessonClick(it.id)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonListPreview() {

    LessonList(dummyLessons, onLessonClick = {})
}