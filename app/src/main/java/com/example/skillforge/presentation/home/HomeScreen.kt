package com.example.skillforge.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.dummyCategories
import com.example.skillforge.domain.model.dummyCourses
import com.example.skillforge.presentation.home.components.CategoryRow
import com.example.skillforge.presentation.home.components.CourseList
import com.example.skillforge.presentation.home.components.HeaderSection
import com.example.skillforge.presentation.home.components.ScrollIndicator
import com.example.skillforge.presentation.home.components.CustomSearchBar
import com.example.skillforge.presentation.home.components.SectionHeader

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun HomeScreen(
    state: HomeStates,
    onEvent: (HomeEvents) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF7F7F7)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            HeaderSection()

            Spacer(modifier = Modifier.height(20.dp))

            CustomSearchBar()

            Spacer(modifier = Modifier.height(28.dp))

            SectionHeader("Categories")

            Spacer(modifier = Modifier.height(16.dp))

            CategoryRow(categories = dummyCategories)

            Spacer(modifier = Modifier.height(12.dp))

            ScrollIndicator()

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader("Popular courses")

            Spacer(modifier = Modifier.height(16.dp))

            CourseList(courses = dummyCourses)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SkillforgeTheme {
        HomeScreen(
            state = HomeStates(),
            onEvent = {}
        )
    }
}