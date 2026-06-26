package com.example.skillforge.domain.dto_response
import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    @SerializedName("level")
    val level: String,

    @SerializedName("durationHours")
    val durationHours: String,

    @SerializedName("rating")
    val rating: String,

    @SerializedName("studentsEnrolled")
    val studentsEnrolled: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("lastUpdated")
    val lastUpdated: String,

    @SerializedName("tags")
    val tags: List<String>,

    @SerializedName("instructor")
    val instructor: InstructorResponse,

    @SerializedName("description")
    val description: String,

    @SerializedName("lessons")
    val lessons: List<LessonResponse>
)
