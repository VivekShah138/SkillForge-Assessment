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
import com.example.skillforge.domain.model.dummyCourses

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
    val courses = dummyCourses

    CourseList(courses = courses)
}