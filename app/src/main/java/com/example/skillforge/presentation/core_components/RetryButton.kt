package com.example.skillforge.presentation.core_components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RetryButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2CC4BC)
        )
    ) {
        Icon(
            imageVector = Icons.Outlined.Refresh,
            contentDescription = null,
            tint = Color(0xFF083B3A)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Retry",
            color = Color(0xFF083B3A)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RetryPreview() {
    RetryButton()
}