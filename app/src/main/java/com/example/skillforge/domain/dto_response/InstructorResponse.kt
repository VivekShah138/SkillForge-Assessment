package com.example.skillforge.domain.dto_response

import com.google.gson.annotations.SerializedName

data class InstructorResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("avatarUrl")
    val avatarUrl: String,

    @SerializedName("bio")
    val bio: String
)
