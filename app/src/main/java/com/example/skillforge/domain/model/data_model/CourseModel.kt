package com.example.skillforge.domain.model.data_model

data class CourseModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val thumbnailUrl: String,
    val level: String,
    val durationHours: Double,
    val rating: Double,
    val studentsEnrolled: Int,
    val language: String,
    val lastUpdated: String,
    val tags: List<String>,
    val instructor: InstructorModel,
    val description: String,
    val lessons: List<LessonModel>
)
