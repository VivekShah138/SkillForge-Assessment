package com.example.skillforge.presentation.core_components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NoInternetScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color =Color(0xFFF2FBFA)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            NoInternetIllustration()

            Spacer(modifier = Modifier.height(56.dp))

            NoInternetText()

            Spacer(modifier = Modifier.height(56.dp))

            RetryButton()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NoInternetScreenPreview() {
    NoInternetScreen()
}