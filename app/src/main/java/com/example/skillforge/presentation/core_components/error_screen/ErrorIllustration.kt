package com.example.skillforge.presentation.core_components.error_screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CloudOff
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.ErrorType

@Composable
fun ErrorIllustration(
    errorType: ErrorType
) {
    val isGeneralError = errorType == ErrorType.GENERAL_ERROR

    val mainColor = if (isGeneralError) {
        Color(0xFFE53935) // error red
    } else {
        Color(0xFF2CC4BC) // teal
    }

    val lightColor = if (isGeneralError) {
        Color(0xFFFF8A80) // light red
    } else {
        Color(0xFF8DE7E2) // light teal
    }

    val veryLightColor = if (isGeneralError) {
        Color(0xFFFFEBEE) // very light red
    } else {
        Color(0xFFE8FAF9) // very light teal
    }

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
                .background(veryLightColor, CircleShape)
        )

        Box(
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.TopEnd)
                .offset(20.dp, (-20).dp)
                .background(lightColor.copy(alpha = 0.25f), CircleShape)
        )

        Icon(
            imageVector = if (isGeneralError)
                Icons.Outlined.CloudOff
            else
                Icons.Outlined.WifiOff,
            contentDescription = null,
            modifier = Modifier.size(110.dp),
            tint = lightColor
        )

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 80.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Dot(mainColor)
            Dot(lightColor)
            Dot(veryLightColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IllustrationPreview() {
    ErrorIllustration(
        errorType = ErrorType.NO_INTERNET
    )
}

@Preview(showBackground = true)
@Composable
fun IllustrationPreview2() {
    ErrorIllustration(
        errorType = ErrorType.GENERAL_ERROR
    )
}