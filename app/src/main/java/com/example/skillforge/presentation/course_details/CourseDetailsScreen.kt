package com.example.skillforge.presentation.course_details

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillforge.ui.theme.SkillforgeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.ErrorType
import com.example.skillforge.domain.model.LoadingType
import com.example.skillforge.presentation.core_components.error_screen.ErrorScreen
import com.example.skillforge.presentation.core_components.loading_screen.LoadingScreen
import com.example.skillforge.presentation.course_details.components.BottomEnrollSection
import com.example.skillforge.presentation.course_details.components.CourseBanner
import com.example.skillforge.presentation.course_details.components.CourseContentHeader
import com.example.skillforge.presentation.course_details.components.CourseInfoSection
import com.example.skillforge.presentation.course_details.components.DescriptionSection
import com.example.skillforge.presentation.course_details.components.InstructorCard
import com.example.skillforge.presentation.course_details.components.LessonCard
import com.example.skillforge.utils.events.CourseDetailsNavigationEvent
import com.example.skillforge.utils.events.CourseDetailsUiEvents
import com.example.skillforge.utils.mapper.toLessonSummary
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun CourseDetailsRoot(
    viewModel: CourseDetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onLessonClick: (lessonId: String, courseId: String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CourseDetailsScreen(
        state = state,
        onEvent = viewModel::onEvent,
        onBackClick = onBackClick,
        onLessonClick = onLessonClick,
        courseDetailsNavigationEvent = viewModel.navigationEvent
    )
}

@Composable
fun CourseDetailsScreen(
    state: CourseDetailsStates,
    onEvent: (CourseDetailsEvents) -> Unit,
    onBackClick: () -> Unit,
    onLessonClick: (lessonId: String, courseId: String) -> Unit,
    courseDetailsNavigationEvent: SharedFlow<CourseDetailsNavigationEvent>
) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        courseDetailsNavigationEvent.collect { event ->
            when (event) {
                is CourseDetailsNavigationEvent.OnSuccess -> {
                    onLessonClick(event.lessonId, event.courseId)
                }

                is CourseDetailsNavigationEvent.OnFailure -> {
                    Toast.makeText(
                        context,
                        "This lesson is locked 🔒",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    Scaffold { paddingValues ->
        when (state.uiEvents) {
            is CourseDetailsUiEvents.Success -> {
                CourseDetailsSuccessScreen(
                    paddingValues = paddingValues,
                    courseModel = state.uiEvents.course,
                    onEvent = onEvent,
                    onBackClick = onBackClick
                )
            }

            is CourseDetailsUiEvents.Loading -> {
                LoadingScreen(
                    type = LoadingType.COURSES
                )
            }

            is CourseDetailsUiEvents.NoInternet -> {
                ErrorScreen(
                    errorType = ErrorType.NO_INTERNET,
                    onRetryClick = {
                        onEvent(CourseDetailsEvents.OnClickRetry)
                    }
                )
            }

            is CourseDetailsUiEvents.Error -> {
                ErrorScreen(
                    errorType = ErrorType.GENERAL_ERROR,
                    onRetryClick = {
                        onEvent(CourseDetailsEvents.OnClickRetry)
                    }
                )
            }
        }
    }
}

@Composable
fun CourseDetailsSuccessScreen(
    paddingValues: PaddingValues,
    courseModel: CourseModel,
    onEvent: (CourseDetailsEvents) -> Unit,
    onBackClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        color = Color(0xFFF7F7F7)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CourseBanner(
                course = courseModel,
                onBackClick = {
                    onBackClick()
                },
                onBookMarkClick = {
                    // TODO
                }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.height(18.dp))

                CourseInfoSection(
                    course = courseModel
                )

                Spacer(Modifier.height(18.dp))

                InstructorCard(
                    instructorModel = courseModel.instructor
                )

                Spacer(Modifier.height(15.dp))

                DescriptionSection(
                    description = courseModel.description
                )

                Spacer(Modifier.height(20.dp))

                CourseContentHeader(
                    lessonsMetadata = courseModel.lessons.toLessonSummary()
                )

                Spacer(Modifier.height(16.dp))

                courseModel.lessons.forEach {
                    LessonCard(
                        lesson = it,
                        onClick = {
                            onEvent(
                                CourseDetailsEvents.OnLessonClick(
                                    lessonId = it.id,
                                    courseId = courseModel.id,
                                    isFree = it.isFree
                                )
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            BottomEnrollSection()
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SkillforgeTheme {
        CourseDetailsScreen(
            state = CourseDetailsStates(),
            onEvent = {},
            onBackClick = {},
            onLessonClick = { _, _ -> },
            courseDetailsNavigationEvent = MutableSharedFlow()
        )
    }
}