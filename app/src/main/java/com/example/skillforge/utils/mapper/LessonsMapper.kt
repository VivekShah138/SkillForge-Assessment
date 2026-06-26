package com.example.skillforge.utils.mapper

import com.example.skillforge.domain.model.LessonModel
import com.example.skillforge.domain.dto_response.LessonResponse

fun LessonResponse.toLessonModel(): LessonModel {
    return LessonModel(
        id = id,
        title = title,
        durationMinutes = durationMinutes.toIntOrNull() ?: 0,
        isFree = isFree.toBooleanStrictOrNull() ?: false,
        videoUrl = videoUrl,
        content = content
    )
}