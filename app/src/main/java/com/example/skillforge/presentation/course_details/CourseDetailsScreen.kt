package com.example.skillforge.presentation.course_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme

@Composable
fun CourseDetailsRoot(
    viewModel: CourseDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CourseDetailsScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun CourseDetailsScreen(
    state: CourseDetailsStates,
    onEvent: (CourseDetailsEvents) -> Unit,
) {

}

@Preview
@Composable
private fun Preview() {
    SkillforgeTheme {
        CourseDetailsScreen(
            state = CourseDetailsStates(),
            onEvent = {}
        )
    }
}