package com.example.skillforge.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.model.CourseModel

@Composable
fun FullSearchContent(
    searchValue: String,
    searchMode: FullSearchMode,
    categories: List<CategoryModel>,
    courses: List<CourseModel>,
    onSearchChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    onCourseClick: (String) -> Unit,
    paddingValues: PaddingValues
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        color = Color(0xFFF7F7F7)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 24.dp)
        ) {
            CustomSearchBar(
                query = searchValue,
                onQueryChange = onSearchChange,
                onCancelClick = onCancelClick
            )

            Spacer(modifier = Modifier.height(24.dp))

            when (searchMode) {
                FullSearchMode.CATEGORY -> {
                    CategoryGrid(categories)
                }

                FullSearchMode.COURSE -> {
                    CourseList(
                        courses = courses,
                        onClick = onCourseClick
                    )
                }
            }
        }
    }
}