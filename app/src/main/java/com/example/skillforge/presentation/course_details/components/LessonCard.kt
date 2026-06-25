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
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.utils.dummyLessons
import com.example.skillforge.ui.theme.labelXSmall
import com.example.skillforge.ui.theme.titleXSmall

@Composable
fun LessonCard(
    lesson: LessonModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick
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
                        Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = if (!lesson.isFree) Color.Gray else Color(0xFF00B8A9)
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 18.sp
                    )
                )
                Text(
                    text = "${lesson.durationMinutes} min",
                    style = MaterialTheme.typography.titleXSmall.copy(
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                )
            }

            Spacer(Modifier.width(10.dp))

            if (lesson.isFree) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFD9FFF7))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "FREE",
                        style = MaterialTheme.typography.labelXSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00B8A9)
                        )
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
        dummyLessons[0],
        onClick = {

        }
    )
}