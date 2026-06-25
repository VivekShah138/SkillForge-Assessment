package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CourseModel

@Composable
fun CourseList(courses: List<CourseModel>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(courses) {
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
            duration = "12h 30m",
            imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=UI%2FUX+Foundations"
        ),
        CourseModel(
            title = "Advanced Android Development",
            author = "Jane Smith",
            level = "INTERMEDIATE",
            rating = "4.7",
            duration = "18h 10m",
            imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Figma+for+Developers"
        )
    )

    CourseList(courses = courses)
}