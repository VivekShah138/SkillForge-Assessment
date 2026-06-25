package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.skillforge.utils.dummyCourses
import com.example.skillforge.utils.dummyLessons


@Composable
fun VideoHeader(
    imageUrl: String,
    onBackClick: () -> Unit,
    onFullScreenClick: () -> Unit,
    selectedLessonDuration: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
    ) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = "Course Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(14.dp))
                .align(Alignment.Center),
            loading = {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            },
            error = {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Failed")
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CircleIcon(
                Icons.AutoMirrored.Filled.ArrowBack,
                onIconClick = {
                    onBackClick()
                }
            )
            CircleIcon(
                Icons.Outlined.Fullscreen,
                onIconClick = {
                    onFullScreenClick()
                }
            )
        }

        PlayButton(
            modifier = Modifier.align(Alignment.Center)
        )

        VideoProgress(
            modifier = Modifier.align(Alignment.BottomCenter),
            durationMinutes = selectedLessonDuration
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun VideoHeaderPreview() {
    VideoHeader(
        imageUrl = dummyCourses[0].thumbnailUrl,
        onBackClick = {

        },
        onFullScreenClick = {

        },
        selectedLessonDuration = dummyLessons[0].durationMinutes
    )
}