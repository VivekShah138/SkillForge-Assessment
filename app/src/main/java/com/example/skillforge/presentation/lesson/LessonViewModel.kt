package com.example.skillforge.presentation.lesson

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.skillforge.domain.model.LessonTabs
import com.example.skillforge.domain.model.NetworkStatus
import com.example.skillforge.domain.usecase.usecase_wrapper.LessonScreenUseCaseWrapper
import com.example.skillforge.navigation.Screens
import com.example.skillforge.utils.events.LessonOnClickEvent
import com.example.skillforge.utils.Logger
import com.example.skillforge.utils.events.CourseDetailsUiEvents
import com.example.skillforge.utils.events.HomeScreenUiEvents
import com.example.skillforge.utils.events.LessonUiEvents
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
class LessonViewModel @Inject constructor(
    private val lessonScreenUseCaseWrapper: LessonScreenUseCaseWrapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(LessonStates())
    val state: StateFlow<LessonStates> = _state.asStateFlow()

    private val _lessonOnClickEvent = MutableSharedFlow<LessonOnClickEvent>()
    val lessonOnClickEvent: SharedFlow<LessonOnClickEvent> =
        _lessonOnClickEvent.asSharedFlow()

    private val route = savedStateHandle.toRoute<Screens.CourseLesson>()
    private val courseId = route.courseId
    private val lessonId = route.lessonId

    init {
        monitorNetwork()
    }

    fun onEvent(events: LessonEvents) {
        when (events) {
            is LessonEvents.OnClickLesson -> {
                clickLesson(
                    lessonId = events.lessonId,
                    isFree = events.isFree
                )
            }

            is LessonEvents.OnClickRetry -> {
                monitorNetwork()
            }

            is LessonEvents.OnClickTab -> {
                onClickTab(tab = events.tab)
            }
        }
    }

    private fun onClickTab(tab: LessonTabs) {
        val currentState = state.value.lessonUiEvents

        if (currentState !is LessonUiEvents.Success) {
            _state.update {
                it.copy(lessonUiEvents = LessonUiEvents.Error)
            }
            return
        }

        if(tab != LessonTabs.LESSONS){
            viewModelScope.launch {
                _lessonOnClickEvent.emit(
                    LessonOnClickEvent.OnFailure(
                        "This section is locked 🔒"
                    )
                )
            }
            return
        }
    }

    private fun monitorNetwork() {
        viewModelScope.launch {
            lessonScreenUseCaseWrapper.networkMonitorLocalUseCase().collect { status ->
                if (status == NetworkStatus.Available) {
                    getData()
                } else {
                    _state.update { it.copy(lessonUiEvents = LessonUiEvents.NoInternet) }
                }
            }
        }
    }

    private suspend fun getData() {
        _state.update { it.copy(lessonUiEvents = LessonUiEvents.Loading) }
        val result = lessonScreenUseCaseWrapper.getCategoriesRemoteUseCase()

        result.onSuccess { categoryList ->
            val allCourses = lessonScreenUseCaseWrapper.getCoursesFromCategoriesUseCase(
                categories = categoryList
            )

            val course = lessonScreenUseCaseWrapper.getCourseByIdUseCase(
                courseId = courseId,
                courseList = allCourses
            )


            if (course == null) {
                _state.update { it.copy(lessonUiEvents = LessonUiEvents.Error) }
                return
            }

            val selectedLesson = lessonScreenUseCaseWrapper.getSelectedLessonUseCase(
                lessonId = lessonId,
                lessonList = course.lessons,
            )

            if (selectedLesson == null) {
                _state.update { it.copy(lessonUiEvents = LessonUiEvents.Error) }
                return
            }


            _state.update {
                it.copy(
                    lessonUiEvents = LessonUiEvents.Success(
                        course = course,
                        selectedLesson = selectedLesson
                    )
                )
            }

            Logger.d(Logger.Tag.LESSON_VIEWMODEL, "selectedCourse => $course")
            Logger.d(Logger.Tag.LESSON_VIEWMODEL, "selectedLesson => $selectedLesson")

        }.onFailure { error ->
            _state.update {
                it.copy(lessonUiEvents = LessonUiEvents.Error)
            }
            Logger.e(Logger.Tag.LESSON_VIEWMODEL, "Error => ${error.localizedMessage}")

        }
    }

    private fun clickLesson(
        lessonId: String,
        isFree: Boolean
    ) {
        val currentState = state.value.lessonUiEvents

        if (currentState !is LessonUiEvents.Success) {
            _state.update {
                it.copy(lessonUiEvents = LessonUiEvents.Error)
            }
            return
        }

        if (!isFree) {
            viewModelScope.launch {
                _lessonOnClickEvent.emit(
                    LessonOnClickEvent.OnFailure(
                        "This lesson is locked 🔒"
                    )
                )
            }
            return
        }

        val selectedLesson =
            lessonScreenUseCaseWrapper.getSelectedLessonUseCase(
                lessonId = lessonId,
                lessonList = currentState.course.lessons
            )

        if (selectedLesson != null) {
            _state.update {
                it.copy(
                    lessonUiEvents = currentState.copy(
                        selectedLesson = selectedLesson
                    )
                )
            }
        } else {
            _state.update {
                it.copy(lessonUiEvents = LessonUiEvents.Error)
            }
        }
    }
}