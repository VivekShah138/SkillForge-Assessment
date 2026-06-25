package com.example.skillforge.domain.model.data_model

data class LessonModel(
    val id: String,
    val title: String,
    val durationMinutes: Int,
    val isFree: Boolean,
    val videoUrl: String,
    val content: String
)
