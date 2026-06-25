package com.example.skillforge.presentation.lesson

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.skillforge.domain.usecase.usecase_wrapper.LessonScreenUseCaseWrapper
import com.example.skillforge.navigation.Screens
import com.example.skillforge.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LessonViewModel @Inject constructor(
    private val lessonScreenUseCaseWrapper: LessonScreenUseCaseWrapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(LessonStates())
    val state: StateFlow<LessonStates> = _state.asStateFlow()

    private val route = savedStateHandle.toRoute<Screens.CourseLesson>()
    private val courseId = route.courseId
    private val lessonId = route.lessonId

    init {
        getData()
    }

    fun onEvent(events: LessonEvents) {
        when (events) {
            else -> TODO("Handle actions")
        }
    }

    fun getData() {
        viewModelScope.launch {
            val result = lessonScreenUseCaseWrapper.getCategoriesRemoteUseCase()

            result.onSuccess { categoryList ->
                val allCourses = lessonScreenUseCaseWrapper.getCoursesFromCategoriesUseCase(
                    categories = categoryList
                )

                val course = lessonScreenUseCaseWrapper.getCourseByIdUseCase(
                    courseId = courseId,
                    courseList = allCourses
                )


                if (course == null) return@launch

                val selectedLesson = lessonScreenUseCaseWrapper.getSelectedLessonUseCase(
                    lessonId = lessonId,
                    lessonList = course.lessons,
                )


                _state.update { it.copy(selectedCourse = course, selectedLesson = selectedLesson) }

                Logger.d(Logger.Tag.LESSON_VIEWMODEL, "selectedCourse => $course")
                Logger.d(Logger.Tag.LESSON_VIEWMODEL, "selectedLesson => $selectedLesson")

            }.onFailure { error ->
                Logger.e(Logger.Tag.LESSON_VIEWMODEL, "Error => ${error.localizedMessage}")
            }
        }
    }
}