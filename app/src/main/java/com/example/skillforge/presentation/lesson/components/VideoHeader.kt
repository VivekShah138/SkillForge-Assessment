package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun VideoHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF00695C),
                        Color(0xFF004D40)
                    )
                )
            )
    ) {
        DecorativeCircle(
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.BottomStart)
        )

        DecorativeCircle(
            modifier = Modifier
                .size(170.dp)
                .align(Alignment.TopEnd)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CircleIcon(Icons.Default.ArrowBack)
            CircleIcon(Icons.Outlined.Fullscreen)
        }

        PlayButton(
            modifier = Modifier.align(Alignment.Center)
        )

        VideoProgress(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun VideoHeaderPreview() {
    VideoHeader()
}