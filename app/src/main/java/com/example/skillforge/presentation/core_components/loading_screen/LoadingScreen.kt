package com.example.skillforge.presentation.core_components.loading_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.data_model.LoadingType

@Composable
fun LoadingScreen(
    type: LoadingType
) {
    val title = when (type) {
        LoadingType.HOME -> "Loading everything..."
        LoadingType.COURSES -> "Loading courses..."
        LoadingType.LESSONS -> "Loading lessons..."
    }

    val subtitle = when (type) {
        LoadingType.HOME -> "Please wait while we fetch fresh content"
        LoadingType.COURSES -> "Please wait while we fetch fresh content"
        LoadingType.LESSONS -> "Please wait while we fetch lesson content"
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F8F8)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(80.dp))

            LoadingHeader()

            Spacer(Modifier.height(32.dp))

            CircularLoader()

            Spacer(Modifier.height(36.dp))

            Text(
                title,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            Text(
                subtitle,
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(Modifier.height(48.dp))

            repeat(3) {
                ShimmerCourseCard()
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeLoadingPreview() {
    LoadingScreen(LoadingType.HOME)
}