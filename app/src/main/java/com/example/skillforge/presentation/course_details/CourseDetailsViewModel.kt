package com.example.skillforge.presentation.course_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.skillforge.domain.model.NetworkStatus
import com.example.skillforge.domain.usecase.usecase_wrapper.CourseDetailsUseCaseWrapper
import com.example.skillforge.navigation.Screens
import com.example.skillforge.utils.events.CourseDetailsNavigationEvent
import com.example.skillforge.utils.Logger
import com.example.skillforge.utils.events.CourseDetailsUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
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

    private val _navigationEvent =
        MutableSharedFlow<CourseDetailsNavigationEvent>()

    val navigationEvent: SharedFlow<CourseDetailsNavigationEvent> =
        _navigationEvent.asSharedFlow()

    private val route = savedStateHandle.toRoute<Screens.CourseDetails>()
    private val courseId = route.courseId

    init {
        monitorNetwork()
    }

    fun onEvent(events: CourseDetailsEvents) {
        when (events) {
            is CourseDetailsEvents.OnLessonClick -> navigate(
                courseId = events.courseId,
                lessonId = events.lessonId,
                isFree = events.isFree
            )

            CourseDetailsEvents.OnClickRetry -> {
                monitorNetwork()
            }
        }
    }

    private fun navigate(
        lessonId: String,
        courseId: String,
        isFree: Boolean
    ) {
        viewModelScope.launch {
            if (isFree) {
                _navigationEvent.emit(
                    CourseDetailsNavigationEvent.OnSuccess(
                        lessonId = lessonId,
                        courseId = courseId
                    )
                )
            } else {
                _navigationEvent.emit(
                    CourseDetailsNavigationEvent.OnFailure
                )
            }
        }

    }


    fun monitorNetwork() {
        viewModelScope.launch {
            courseDetailsUseCaseWrapper.networkMonitorLocalUseCase().collect { status ->
                if (status == NetworkStatus.Available) {
                    getData()
                } else {
                    _state.update { it.copy(uiEvents = CourseDetailsUiEvents.NoInternet) }
                }
            }
        }
    }

    suspend fun getData() {
        _state.update { it.copy(uiEvents = CourseDetailsUiEvents.Loading) }
        val result = courseDetailsUseCaseWrapper.getCategoriesRemoteUseCase()

        result.onSuccess { categoryList ->
            val allCourses = courseDetailsUseCaseWrapper.getCoursesFromCategoriesUseCase(
                categories = categoryList
            )


            val course = courseDetailsUseCaseWrapper.getCourseByIdUseCase(
                courseId = courseId,
                courseList = allCourses
            )

            if (course != null) {
                Logger.d(Logger.Tag.COURSE_DETAILS_VIEWMODEL, "selectedCourse => $course")
                _state.update { it.copy(uiEvents = CourseDetailsUiEvents.Success(course = course)) }
            } else {
                _state.update { it.copy(uiEvents = CourseDetailsUiEvents.Error) }
            }


        }.onFailure { error ->
            Logger.e(Logger.Tag.COURSE_DETAILS_VIEWMODEL, "Error => ${error.localizedMessage}")
            _state.update { it.copy(uiEvents = CourseDetailsUiEvents.Error) }
        }
    }
}