package com.example.skillforge.domain.model.response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("categories")
    val categories: List<CategoryResponse>
)
