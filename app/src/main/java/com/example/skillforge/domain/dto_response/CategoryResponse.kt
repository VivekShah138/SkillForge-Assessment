package com.example.skillforge.domain.dto_response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("iconColor")
    val iconColor: String,

    @SerializedName("courseCount")
    val courseCount: String,

    @SerializedName("courses")
    val courses: List<CoursesResponse>
)
