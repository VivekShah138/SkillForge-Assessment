package com.example.skillforge.utils

interface LessonOnClickEvent {
    data class OnFailure(val error: String) : LessonOnClickEvent
}