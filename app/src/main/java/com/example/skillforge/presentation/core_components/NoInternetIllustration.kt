package com.example.skillforge.presentation.core_components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun NoInternetIllustration() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .align(Alignment.BottomStart)
                .offset((-25).dp, 25.dp)
                .background(
                    Color(0xFFF5F5F5),
                    CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.TopEnd)
                .offset(20.dp, (-20).dp)
                .background(
                    Color(0xFFF3F7F7),
                    CircleShape
                )
        )

        Icon(
            imageVector = Icons.Outlined.WifiOff,
            contentDescription = null,
            modifier = Modifier.size(110.dp),
            tint = Color(0xFFB8C7C5)
        )

        Box(
            modifier = Modifier
                .size(14.dp)
                .offset(x = 65.dp, y = (-55).dp)
                .background(Color.Red, CircleShape)
        )

        Row(
            modifier = Modifier.align(Alignment.Center).offset(y = 80.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Dot(Color(0xFF2CC4BC))
            Dot(Color(0xFFC9D1D1))
            Dot(Color(0xFFC9D1D1))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IllustrationPreview() {
    NoInternetIllustration()
}