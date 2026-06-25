package com.example.skillforge.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme

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