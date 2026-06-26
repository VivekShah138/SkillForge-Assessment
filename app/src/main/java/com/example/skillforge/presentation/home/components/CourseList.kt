package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.utils.dummyCourses

@Composable
fun CourseList(
    courses: List<CourseModel>,
    onClick: (courseId: String) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(courses) {
            CourseCard(
                course = it,
                onClick = {
                    onClick(it.id)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListPreview() {
    val courses = dummyCourses

    CourseList(
        courses = courses,
        onClick = {

        }
    )
}