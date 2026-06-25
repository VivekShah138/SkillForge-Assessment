package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.ui.theme.SkillforgeTheme
import com.example.skillforge.ui.theme.labelXSmall

@Composable
fun CategoryCard(category: CategoryModel) {
    Card(
        modifier = Modifier.width(140.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFDDF7F2)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF2ACB98))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = category.title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 18.sp
                ),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = category.courseCount,
                style = MaterialTheme.typography.labelXSmall.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    SkillforgeTheme {
        CategoryCard(
            category = CategoryModel(
                title = "Android Development",
                courseCount = "24 Courses"
            )
        )
    }
}