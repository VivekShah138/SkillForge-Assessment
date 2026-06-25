package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.data_model.CategoryModel
import com.example.skillforge.utils.dummyCategories

@Composable
fun CategoryRow(categories: List<CategoryModel>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) {
            CategoryCard(it)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    CategoryRow(categories = dummyCategories)
}