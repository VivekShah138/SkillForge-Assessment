package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.CourseModel


@Composable
fun CourseCard(course: CourseModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            CourseThumbnail()

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    course.level,
                    color = if (course.level == "BEGINNER")
                        Color(0xFF00B8A9)
                    else
                        Color(0xFFFF9800),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    course.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    course.author,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⭐ ${course.rating}")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("🕒 ${course.duration}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    CourseCard(
        course = CourseModel(
            title = "Complete UI/UX Design Bootcamp",
            author = "John Doe",
            level = "BEGINNER",
            rating = "4.9",
            duration = "12h 30m"
        )
    )
}