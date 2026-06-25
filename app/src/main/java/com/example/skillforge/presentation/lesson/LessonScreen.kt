package com.example.skillforge.presentation.lesson

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.skillforge.utils.dummyCourses
import com.example.skillforge.utils.dummyLessons
import com.example.skillforge.presentation.lesson.components.LessonDetailsSection
import com.example.skillforge.presentation.lesson.components.LessonList
import com.example.skillforge.presentation.lesson.components.LessonTabs
import com.example.skillforge.presentation.lesson.components.VideoHeader

@Composable
fun LessonRoot(
    viewModel: LessonViewModel = hiltViewModel(),
    navigateToPreviousScreen: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LessonScreen(
        state = state,
        onEvent = viewModel::onEvent,
        navigateToPreviousScreen = navigateToPreviousScreen
    )
}

@Composable
fun LessonScreen(
    state: LessonStates,
    onEvent: (LessonEvents) -> Unit,
    navigateToPreviousScreen: () -> Unit
) {
    Scaffold(

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            color = Color(0xFFF8F8F8)
        ) {
            Column {
                VideoHeader(
                    imageUrl = dummyCourses[0].thumbnailUrl,
                    onBackClick = {
                        navigateToPreviousScreen()
                    },
                    onFullScreenClick = {

                    },
                )

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    LessonDetailsSection(
                        lessonModel = dummyLessons[0]
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    LessonTabs()

                    Spacer(modifier = Modifier.height(16.dp))

                    LessonList(dummyLessons)
                }
            }
        }

    }
}

@Preview
@Composable
private fun Preview() {
    SkillforgeTheme {
        LessonScreen(
            state = LessonStates(),
            onEvent = {},
            navigateToPreviousScreen = {
                
            }
        )
    }
}