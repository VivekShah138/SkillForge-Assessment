package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScrollIndicator() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(width = 14.dp, height = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(width = 180.dp, height = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollIndicatorPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ScrollIndicator()
    }
}