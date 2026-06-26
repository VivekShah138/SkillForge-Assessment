package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.utils.dummyCategories

@Composable
fun CategoryRow(categories: List<CategoryModel>) {

    if (categories.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No categories found",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Try another search",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                )
            }
        }
    } else {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    CategoryRow(categories = dummyCategories)
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview2() {
    CategoryRow(categories = emptyList())
}