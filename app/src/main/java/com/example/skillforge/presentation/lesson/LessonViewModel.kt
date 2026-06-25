package com.example.skillforge.presentation.lesson

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class LessonViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(LessonStates())
    val state: StateFlow<LessonStates> = _state.asStateFlow()

    init {

    }

    fun onEvent(events: LessonEvents) {
        when (events) {
            else -> TODO("Handle actions")
        }
    }
}