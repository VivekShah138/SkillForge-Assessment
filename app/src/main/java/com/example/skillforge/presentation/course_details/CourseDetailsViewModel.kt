package com.example.skillforge.presentation.course_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.skillforge.domain.usecase.usecase_wrapper.CourseDetailsUseCaseWrapper
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
class CourseDetailsViewModel @Inject constructor(
    private val courseDetailsUseCaseWrapper: CourseDetailsUseCaseWrapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(CourseDetailsStates())
    val state: StateFlow<CourseDetailsStates> = _state.asStateFlow()

    private val route = savedStateHandle.toRoute<Screens.CourseDetails>()
    private val courseId = route.courseId

    init {
        getData()
    }

    fun onEvent(events: CourseDetailsEvents) {
        when (events) {
            else -> TODO("Handle actions")
        }
    }

    fun getData(){
        viewModelScope.launch {
            val result = courseDetailsUseCaseWrapper.getCategoriesRemoteUseCase()

            result.onSuccess { categoryList ->
                categoryList.forEach { categoryModel ->
                    val allCourses =  courseDetailsUseCaseWrapper.getCoursesFromCategoriesUseCase(
                        categories = categoryList
                    )

                    val course = courseDetailsUseCaseWrapper.getCourseByIdUseCase(
                        courseId = courseId,
                        courseList = allCourses
                    )

                    _state.update { it.copy(selectedCourse = course) }

                    Logger.d(Logger.Tag.COURSE_DETAILS_VIEWMODEL, "selectedCourse => $course")


                }
            }.onFailure { error ->
                Logger.e(Logger.Tag.HOME_VIEWMODEL, "Error => ${error.localizedMessage}")
            }
        }
    }
}