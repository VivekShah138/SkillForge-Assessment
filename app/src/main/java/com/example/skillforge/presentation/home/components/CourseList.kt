package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CourseModel

@Composable
fun CourseList(courses: List<CourseModel>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        courses.forEach {
            CourseCard(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    val courses = listOf(
        CourseModel(
            title = "Complete UI/UX Design",
            author = "John Doe",
            level = "BEGINNER",
            rating = "4.8",
            duration = "12h 30m"
        ),
        CourseModel(
            title = "Advanced Android Development",
            author = "Jane Smith",
            level = "INTERMEDIATE",
            rating = "4.7",
            duration = "18h 10m"
        )
    )

    CourseList(courses = courses)
}