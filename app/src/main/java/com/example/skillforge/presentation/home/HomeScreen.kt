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
import com.example.skillforge.domain.model.ErrorType
import com.example.skillforge.domain.model.LoadingType
import com.example.skillforge.presentation.core_components.error_screen.ErrorScreen
import com.example.skillforge.presentation.core_components.loading_screen.LoadingScreen
import com.example.skillforge.utils.dummyCategories
import com.example.skillforge.utils.dummyCourses
import com.example.skillforge.presentation.home.components.CategoryRow
import com.example.skillforge.presentation.home.components.CourseList
import com.example.skillforge.presentation.home.components.HeaderSection
import com.example.skillforge.presentation.home.components.CustomSearchBar
import com.example.skillforge.presentation.home.components.SectionHeader
import com.example.skillforge.utils.events.HomeScreenUiEvents

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToCourse: (courseId: String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onEvent = viewModel::onEvent,
        navigateToCourse = navigateToCourse
    )
}

@Composable
fun HomeScreen(
    state: HomeStates,
    onEvent: (HomeEvents) -> Unit,
    navigateToCourse: (courseId: String) -> Unit
) {
    Scaffold(
        containerColor = Color(0xFFF7F7F7)
    ) { paddingValues ->

        when (state.homeScreenUiEvents) {
            is HomeScreenUiEvents.Success -> {
                NormalHomeScreen(
                    paddingValues = paddingValues,
                    state = state,
                    onEvent = onEvent,
                    navigateToCourse = navigateToCourse
                )
            }

            is HomeScreenUiEvents.Error -> {
                ErrorScreen(
                    errorType = ErrorType.GENERAL_ERROR,
                    onRetryClick = {
                        onEvent(HomeEvents.OnClickRetry)
                    }
                )
            }

            is HomeScreenUiEvents.NoInternet -> {
                ErrorScreen(
                    errorType = ErrorType.NO_INTERNET,
                    onRetryClick = {
                        onEvent(HomeEvents.OnClickRetry)
                    }
                )
            }

            is HomeScreenUiEvents.Loading -> {
                LoadingScreen(
                    type = LoadingType.HOME
                )
            }
        }
    }
}

@Composable
fun NormalHomeScreen(
    paddingValues: PaddingValues,
    state: HomeStates,
    onEvent: (HomeEvents) -> Unit,
    navigateToCourse: (courseId: String) -> Unit
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
                .padding(24.dp)
        ) {
            HeaderSection()

            Spacer(modifier = Modifier.height(20.dp))

            CustomSearchBar(
                query = state.searchValue,
                onQueryChange = {
                    onEvent(HomeEvents.OnValueSearch(it))
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            SectionHeader(
                title = "Categories",
                onClick = {

                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryRow(categories = state.filteredCategoryList)

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(
                title = "Popular courses",
                onClick = {

                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CourseList(
                courses = state.filteredCourseList,
                onClick = {
                    navigateToCourse(it)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun Preview() {
    SkillforgeTheme {
        HomeScreen(
            state = HomeStates(
                categoryList = dummyCategories,
                courseList = dummyCourses
            ),
            onEvent = {},
            navigateToCourse = {}

        )
    }
}