package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DecorativeCircle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(
            Color.White.copy(alpha = 0.06f),
            CircleShape
        )
    )
}

@Preview(
    showBackground = true
)
@Composable
fun DecorativeCirclePreview() {
    DecorativeCircle(Modifier.size(100.dp))
}