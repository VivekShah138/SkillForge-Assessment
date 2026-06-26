package com.example.skillforge.utils.events

interface LessonOnClickEvent {
    data class OnFailure(val error: String) : LessonOnClickEvent
}