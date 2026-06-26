package com.example.skillforge.utils.events

sealed interface LessonOnClickEvent {
    data class OnFailure(val error: String) : LessonOnClickEvent
}