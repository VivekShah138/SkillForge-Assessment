package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.LessonModel

@Composable
fun LessonCard(lesson: LessonModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(
                        if (!lesson.isFree)
                            Color(0xFFF1F1F1)
                        else
                            Color(0xFFDDF7F2)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (!lesson.isFree)
                        Icons.Outlined.Lock
                    else
                        Icons.Outlined.PlayArrow,
                    contentDescription = null,
                    tint = if (lesson.isFree) Color.Gray else Color(0xFF00B8A9)
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    lesson.title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    lesson.duration,
                    color = Color.Gray
                )
            }

            if (lesson.isFree) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFD9FFF7))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        "FREE",
                        color = Color(0xFF00B8A9)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonPreview() {
    LessonCard(
        LessonModel("Welcome & Setup", "8 min", true)
    )
}