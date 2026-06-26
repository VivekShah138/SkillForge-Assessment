package com.example.skillforge.utils.mapper

import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.dto_response.CoursesResponse

fun CoursesResponse.toCourseModel(): CourseModel {
    return CourseModel(
        id = id,
        title = title,
        subtitle = subtitle,
        thumbnailUrl = thumbnailUrl,
        level = level,
        durationHours = durationHours.toDoubleOrNull() ?: 0.0,
        rating = rating.toDoubleOrNull() ?: 0.0,
        studentsEnrolled = studentsEnrolled.toIntOrNull() ?: 0,
        language = language,
        lastUpdated = lastUpdated,
        tags = tags,
        instructor = instructor.toInstructorModel(),
        description = description,
        lessons = lessons.map { it.toLessonModel() }
    )
}