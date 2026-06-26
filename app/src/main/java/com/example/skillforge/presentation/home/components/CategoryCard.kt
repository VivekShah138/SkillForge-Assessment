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
import com.example.skillforge.utils.dummyCategories
import com.example.skillforge.ui.theme.SkillforgeTheme
import com.example.skillforge.ui.theme.labelXSmall
import com.example.skillforge.utils.mapper.toColor

@Composable
fun CategoryCard(category: CategoryModel) {
    Card(
        modifier = Modifier.width(140.dp).height(150.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
//                    .background(Color(0xFFDDF7F2)),
                    .background(category.iconColor.toColor().copy(alpha = 0.25f)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(4.dp))
//                        .background(Color(0xFF2ACB98))
                        .background(category.iconColor.toColor())
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = category.name,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 18.sp
                ),
                maxLines = 2,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = category.courseCount.toString(),
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
            category = dummyCategories[0]
        )
    }
}