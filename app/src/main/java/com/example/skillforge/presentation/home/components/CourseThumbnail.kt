package com.example.skillforge.presentation.home.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage

@Composable
fun CourseThumbnail(imageUrl: String) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "Course Thumbnail",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(width = 92.dp, height = 90.dp)
            .clip(RoundedCornerShape(14.dp)),
        loading = {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        },
        error = {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Text("Failed")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CourseThumbnailPreview() {
    CourseThumbnail(
        imageUrl = "https://images.unsplash.com/photo-1516321318423-f06f85e504b3"
    )
}