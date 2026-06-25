package com.example.skillforge.utils.mapper

import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.domain.model.response.LessonResponse

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