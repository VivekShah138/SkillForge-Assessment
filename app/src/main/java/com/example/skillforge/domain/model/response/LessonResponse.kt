package com.example.skillforge.domain.model.response

import com.google.gson.annotations.SerializedName

data class LessonResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("durationMinutes")
    val durationMinutes: String,

    @SerializedName("isFree")
    val isFree: Boolean,

    @SerializedName("videoUrl")
    val videoUrl: String,

    @SerializedName("content")
    val content: String
)
