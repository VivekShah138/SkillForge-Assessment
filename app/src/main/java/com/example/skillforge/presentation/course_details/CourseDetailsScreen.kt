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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.skillforge.domain.model.dummyCourses
import com.example.skillforge.domain.model.dummyLessons
import com.example.skillforge.presentation.course_details.components.BottomEnrollSection
import com.example.skillforge.presentation.course_details.components.CourseBanner
import com.example.skillforge.presentation.course_details.components.CourseContentHeader
import com.example.skillforge.presentation.course_details.components.CourseInfoSection
import com.example.skillforge.presentation.course_details.components.DescriptionSection
import com.example.skillforge.presentation.course_details.components.InstructorCard
import com.example.skillforge.presentation.course_details.components.LessonCard
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
    Scaffold { paddingValues ->
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
                    course = dummyCourses[0]
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp)
                ) {
                    Spacer(Modifier.height(18.dp))

                    CourseInfoSection(
                        course = dummyCourses[0]
                    )

                    Spacer(Modifier.height(18.dp))

                    InstructorCard()

                    Spacer(Modifier.height(20.dp))

                    DescriptionSection()

                    Spacer(Modifier.height(24.dp))

                    CourseContentHeader()

                    Spacer(Modifier.height(16.dp))

                    dummyLessons.forEach {
                        LessonCard(it)
                        Spacer(Modifier.height(12.dp))
                    }
                }

                BottomEnrollSection()
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
            onEvent = {}
        )
    }
}