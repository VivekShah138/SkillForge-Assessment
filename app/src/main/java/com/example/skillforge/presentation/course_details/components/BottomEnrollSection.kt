package com.example.skillforge.presentation.course_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.ui.theme.labelXSmall

@Composable
fun BottomEnrollSection() {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "PRICE",
                    style = MaterialTheme.typography.labelXSmall.copy(
                        color = Color.Gray,
                    )
                )

                Text(
                    text = "Free",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF00B8A9),
                        fontWeight = FontWeight.Bold,
                    )
                )
            }

            Spacer(Modifier.width(20.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF18B8A8)
                )
            ) {
                Text("Enroll now")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomPreview() {
    BottomEnrollSection()
}