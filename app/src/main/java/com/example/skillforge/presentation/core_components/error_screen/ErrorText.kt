package com.example.skillforge.presentation.core_components.error_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.ErrorType

@Composable
fun ErrorText(
    errorType: ErrorType
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorType.heading,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = errorType.errorMessage,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    ErrorText(
        errorType = ErrorType.NO_INTERNET
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview2() {
    ErrorText(
        errorType = ErrorType.GENERAL_ERROR
    )
}
