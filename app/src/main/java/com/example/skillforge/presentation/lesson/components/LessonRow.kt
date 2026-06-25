package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.LessonModel
import com.example.skillforge.domain.model.dummyLessons
import com.example.skillforge.ui.theme.labelXSmall


@Composable
fun LessonRow(lesson: LessonModel, lessonId: String) {
    val isCurrent = lessonId == lesson.id
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCurrent)
                Color(0xFFDFF7F2)
            else
                Color.White
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        if (isCurrent) Color(0xFF18B8A8)
                        else Color(0xFFDFF7F2),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when {
                        isCurrent -> Icons.Default.Pause
                        !lesson.isFree -> Icons.Outlined.Lock
                        else -> Icons.Outlined.PlayArrow
                    },
                    contentDescription = null,
                    tint = if (isCurrent) Color.White else Color.Gray
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        lineHeight = 18.sp
                    )
                )

                Text(
                    if (isCurrent)
                        "Now playing · ${lesson.durationMinutes} min"
                    else
                        "${lesson.durationMinutes} min",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )

                )
            }

            Spacer(Modifier.width(10.dp))

            if (lesson.isFree) {
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFD9FFF7),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "FREE",
                        style = MaterialTheme.typography.labelXSmall.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF00B8A9)
                        )
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun LessonRowPreview() {
    LessonRow(
        dummyLessons[0], lessonId = "l1"
    )
}

