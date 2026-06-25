package com.example.skillforge.presentation.course_details

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.skillforge.utils.dummyCourses
import com.example.skillforge.utils.dummyLessons
import com.example.skillforge.presentation.course_details.components.BottomEnrollSection
import com.example.skillforge.presentation.course_details.components.CourseBanner
import com.example.skillforge.presentation.course_details.components.CourseContentHeader
import com.example.skillforge.presentation.course_details.components.CourseInfoSection
import com.example.skillforge.presentation.course_details.components.DescriptionSection
import com.example.skillforge.presentation.course_details.components.InstructorCard
import com.example.skillforge.presentation.course_details.components.LessonCard
import com.example.skillforge.presentation.course_details.components.LessonList
import com.example.skillforge.utils.mapper.toLessonSummary

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
        onLessonClick = onLessonClick
    )
}

@Composable
fun CourseDetailsScreen(
    state: CourseDetailsStates,
    onEvent: (CourseDetailsEvents) -> Unit,
    onBackClick: () -> Unit,
    onLessonClick: (lessonId: String, courseId: String) -> Unit
) {
    Scaffold { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            color = Color(0xFFF7F7F7)
        ) {
            if (state.selectedCourse != null) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CourseBanner(
                        course = state.selectedCourse,
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
                            course = state.selectedCourse
                        )

                        Spacer(Modifier.height(18.dp))

                        InstructorCard(
                            instructorModel = state.selectedCourse.instructor
                        )

                        Spacer(Modifier.height(15.dp))

                        DescriptionSection(
                            description = state.selectedCourse.description
                        )

                        Spacer(Modifier.height(20.dp))

                        CourseContentHeader(
                            lessonsMetadata = state.selectedCourse.lessons.toLessonSummary()
                        )

                        Spacer(Modifier.height(16.dp))

                        state.selectedCourse.lessons.forEach {
                            LessonCard(
                                lesson = it,
                                onClick = {
                                    if(it.isFree){
                                        onLessonClick(it.id,state.selectedCourse.id)
                                    }
                                }
                            )
                        }
                    }

                    BottomEnrollSection()
                }
            }
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
            onBackClick = {

            },
            onLessonClick = { _, _ ->

            }
        )
    }
}