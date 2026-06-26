package com.example.skillforge.presentation.lesson

import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.SelectedLesson
import com.example.skillforge.utils.events.LessonUiEvents

data class LessonStates(
    val lessonUiEvents: LessonUiEvents = LessonUiEvents.Loading,
//    val selectedCourse: CourseModel? = null,
//    val selectedLesson: SelectedLesson? = null
)