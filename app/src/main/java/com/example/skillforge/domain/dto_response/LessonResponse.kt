package com.example.skillforge.domain.dto_response

import com.google.gson.annotations.SerializedName

data class LessonResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("durationMinutes")
    val durationMinutes: String,

    @SerializedName("isFree")
    val isFree: String,

    @SerializedName("videoUrl")
    val videoUrl: String,

    @SerializedName("content")
    val content: String
)
