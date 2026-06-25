package com.example.skillforge.presentation.course_details.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionSection() {
    Text(
        text = "Start from zero and learn Kotlin's syntax, null safety, collections, and functions. By the end you'll be comfortable reading and writing idiomatic Kotlin.",
        fontSize = 16.sp,
        lineHeight = 28.sp
    )
}

@Preview(showBackground = true)
@Composable
fun DescriptionPreview() {
    DescriptionSection()
}