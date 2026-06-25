package com.example.skillforge.presentation.lesson

import android.widget.Toast
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.skillforge.presentation.lesson.components.LessonDetailsSection
import com.example.skillforge.presentation.lesson.components.LessonRow
import com.example.skillforge.presentation.lesson.components.LessonTabs
import com.example.skillforge.presentation.lesson.components.VideoHeader
import com.example.skillforge.utils.LessonOnClickEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun LessonRoot(
    viewModel: LessonViewModel = hiltViewModel(),
    navigateToPreviousScreen: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LessonScreen(
        state = state,
        onEvent = viewModel::onEvent,
        navigateToPreviousScreen = navigateToPreviousScreen,
        lessonOnClickEvent = viewModel.lessonOnClickEvent
    )
}

@Composable
fun LessonScreen(
    state: LessonStates,
    onEvent: (LessonEvents) -> Unit,
    navigateToPreviousScreen: () -> Unit,
    lessonOnClickEvent: SharedFlow<LessonOnClickEvent>
) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        lessonOnClickEvent.collect { event ->
            when (event) {
                is LessonOnClickEvent.OnFailure -> {
                    Toast.makeText(
                        context,
                        event.error,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    Scaffold { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            color = Color(0xFFF8F8F8)
        ) {
            if (state.selectedLesson != null && state.selectedCourse != null) {
                Column {
                    VideoHeader(
                        imageUrl = state.selectedCourse.thumbnailUrl,
                        onBackClick = {
                            navigateToPreviousScreen()
                        },
                        onFullScreenClick = {

                        },
                        selectedLessonDuration = state.selectedLesson.lesson.durationMinutes
                    )

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        LessonDetailsSection(
                            lessonModel = state.selectedLesson.lesson,
                            selectedLessonIndex = state.selectedLesson.index,
                            selectedCourseTitle = state.selectedCourse.title
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        LessonTabs()

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(state.selectedCourse.lessons) { lesson ->
                                LessonRow(
                                    lesson = lesson,
                                    lessonId = state.selectedLesson.lesson.id,
                                    onClick = {
                                        onEvent(
                                            LessonEvents.OnClickLesson(
                                                lessonId = lesson.id,
                                                isFree = lesson.isFree
                                            )
                                        )
                                    }
                                )

                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }
                    }
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
            navigateToPreviousScreen = {},
            lessonOnClickEvent = MutableSharedFlow()
        )
    }
}