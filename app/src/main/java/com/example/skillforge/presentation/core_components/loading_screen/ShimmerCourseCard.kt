package com.example.skillforge.presentation.core_components.loading_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ShimmerCourseCard() {
    val brush = shimmerBrush()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
            .padding(20.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 110.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(brush)
            )

            Spacer(Modifier.width(20.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Box(
                    Modifier
                        .width(110.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(50))
                        .background(brush)
                )

                Box(
                    Modifier
                        .width(260.dp)
                        .height(28.dp)
                        .clip(RoundedCornerShape(50))
                        .background(brush)
                )

                Box(
                    Modifier
                        .width(180.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(50))
                        .background(brush)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerPreview() {
    ShimmerCourseCard()
}