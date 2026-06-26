package com.example.skillforge.presentation.core_components.loading_screen

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun shimmerBrush(): Brush {
    val transition = rememberInfiniteTransition(label = "")

    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    return Brush.linearGradient(
        colors = listOf(
            Color(0xFFE8E8E8),
            Color(0xFFF7F7F7),
            Color(0xFFE8E8E8)
        ),
        start = Offset.Zero,
        end = Offset(translateAnim, translateAnim)
    )
}