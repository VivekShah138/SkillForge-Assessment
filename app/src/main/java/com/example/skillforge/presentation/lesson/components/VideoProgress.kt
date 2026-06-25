package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.dummyLessons
import com.example.skillforge.ui.theme.labelXSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoProgress(
    durationMinutes: Int,
    modifier: Modifier = Modifier
) {
    val progress = 0.35f

    val formattedCurrentSeconds = getStartTime(
        durationMinutes = durationMinutes,
        progress = progress
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = formattedCurrentSeconds,
            style = MaterialTheme.typography.labelXSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        )

        val progress = 0.45f

        Slider(
            value = progress,
            onValueChange = {},
            modifier = Modifier
                .weight(1f),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            },

            track = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.Gray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .fillMaxHeight()
                            .background(Color(0xFF00E5A8))
                    )
                }
            }
        )

        Text(
            text = "$durationMinutes:00",
            style = MaterialTheme.typography.labelXSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressPreview() {
    VideoProgress(
        durationMinutes = dummyLessons[0].durationMinutes
    )
}

private fun getStartTime(durationMinutes: Int, progress: Float): String {
    val currentSeconds = (durationMinutes * 60 * progress).toInt()
    val minutes = currentSeconds / 60
    val seconds = currentSeconds % 60
    return "%02d:%02d".format(minutes, seconds)
}