package com.example.skillforge.domain.dto_response

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("categories")
    val categories: List<CategoryResponse>
)
