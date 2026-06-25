package com.example.skillforge.presentation.home.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CourseThumbnail() {
    Box(
        modifier = Modifier
            .size(width = 92.dp, height = 72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF3EC7A5))
    )
}

@Preview(showBackground = true)
@Composable
fun CourseThumbnailPreview() {
    CourseThumbnail()
}