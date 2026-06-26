package com.example.skillforge.presentation.core_components.loading_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CircularLoader() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(Color.Transparent)
        )

        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(Color(0xFF25C7BE).copy(alpha = 0.15f))
        )

        Box(
            modifier = Modifier
                .size(92.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F8F8))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoaderPreview() {
    CircularLoader()
}