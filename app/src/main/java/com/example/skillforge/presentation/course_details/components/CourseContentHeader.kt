package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.skillforge.utils.dummyLessons
import com.example.skillforge.ui.theme.labelXSmall
import com.example.skillforge.utils.mapper.toLessonSummary

@Composable
fun CourseContentHeader(
    lessonsMetadata: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Course content",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
            )
        )

        Text(
            text = lessonsMetadata,
            style = MaterialTheme.typography.labelXSmall.copy(
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CourseContentHeader(
        lessonsMetadata = dummyLessons.toLessonSummary()
    )
}