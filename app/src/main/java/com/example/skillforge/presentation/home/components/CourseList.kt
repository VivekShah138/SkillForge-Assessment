package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.utils.dummyCourses


@Composable
fun CourseList(
    courses: List<CourseModel>,
    onClick: (courseId: String) -> Unit
) {
    if (courses.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No such course found",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            )
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(courses) { course ->
                CourseCard(
                    course = course,
                    onClick = {
                        onClick(course.id)
                    }
                )
            }
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


@Preview(showBackground = true)
@Composable
fun CourseListPreview2() {

    CourseList(
        courses = emptyList(),
        onClick = {

        }
    )
}