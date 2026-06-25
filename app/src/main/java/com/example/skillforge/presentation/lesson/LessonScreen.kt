package com.example.skillforge.presentation.lesson

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme

@Composable
fun LessonRoot(
    viewModel: LessonViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LessonScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun LessonScreen(
    state: LessonStates,
    onEvent: (LessonEvents) -> Unit,
) {

}

@Preview
@Composable
private fun Preview() {
    SkillforgeTheme {
        LessonScreen(
            state = LessonStates(),
            onEvent = {}
        )
    }
}