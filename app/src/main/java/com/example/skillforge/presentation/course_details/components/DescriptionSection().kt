package com.example.skillforge.presentation.course_details.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.skillforge.utils.dummyCourses

@Composable
fun DescriptionSection(
    description: String
) {
    Text(
        text = description,
        style = MaterialTheme.typography.bodySmall
    )
}

@Preview(showBackground = true)
@Composable
fun DescriptionPreview() {
    DescriptionSection(
        description = dummyCourses[0].description
    )
}