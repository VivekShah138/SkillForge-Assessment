package com.example.skillforge.utils.mapper

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import com.example.skillforge.domain.model.LessonModel
import java.text.NumberFormat
import java.util.Locale

fun Int.toFormattedNumber(): String {
    return NumberFormat.getNumberInstance(Locale.US).format(this)
}

fun String.toInitials(): String {
    return this.trim()
        .split(" ")
        .filter { it.isNotEmpty() }
        .take(2)
        .joinToString("") { it.first().uppercase() }
}

fun List<LessonModel>.toLessonSummary(): String {
    val count = size
    val totalMinutes = sumOf { it.durationMinutes }
    val lessonText = if (count == 1) "lesson" else "lessons"

    return "$count lessons • $totalMinutes min"
}

fun String.toColor(): Color {
    return Color(this.toColorInt())
}