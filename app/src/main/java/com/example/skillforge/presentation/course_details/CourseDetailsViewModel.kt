package com.example.skillforge.presentation.course_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class CourseDetailsViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(CourseDetailsStates())
    val state: StateFlow<CourseDetailsStates> = _state.asStateFlow()

    init {

    }

    fun onEvent(events: CourseDetailsEvents) {
        when (events) {
            else -> TODO("Handle actions")
        }
    }
}