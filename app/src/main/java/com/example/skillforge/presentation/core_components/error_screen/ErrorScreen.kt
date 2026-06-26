package com.example.skillforge.presentation.core_components.error_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.data_model.ErrorType


@Composable
fun ErrorScreen(
    errorType: ErrorType = ErrorType.GENERAL_ERROR,
    onRetryClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF2FBFA)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            ErrorIllustration(
                errorType = errorType
            )

            Spacer(modifier = Modifier.height(56.dp))

            ErrorText(
                errorType = errorType
            )

            Spacer(modifier = Modifier.height(56.dp))

            RetryButton(
                onRetryClick = onRetryClick
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(
        onRetryClick = {

        }
    )
}