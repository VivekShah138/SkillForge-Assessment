package com.example.skillforge.presentation.lesson.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun VideoProgress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("02:14", color = Color.White)
            Text("06:00", color = Color.White)
        }

        Slider(
            value = 0.35f,
            onValueChange = {}
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProgressPreview() {
    VideoProgress()
}