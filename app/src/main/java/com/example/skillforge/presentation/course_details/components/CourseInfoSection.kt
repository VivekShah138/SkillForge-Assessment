package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.ui.theme.SkillforgeTheme

@Composable
fun CourseInfoSection(

) {
    Column {
        Text(
            "Kotlin Fundamentals",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(6.dp))

        Text(
            "Everything you need to start writing Kotlin",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("⭐ 4.7")
            Text("18,420")
            Text("⏱ 6.5h")
            Text("Beginner", color = Color(0xFF00B8A9))
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CourseInfoSectionPreview(){
    SkillforgeTheme {
        CourseInfoSection()
    }
}