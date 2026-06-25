package com.example.skillforge.data.data_source.remote

import com.example.skillforge.domain.model.response.ApiResponse
import com.example.skillforge.domain.model.response.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApi {

    @GET("android-assesment/notes/refs/heads/main/data.json")
    suspend fun getAllCategories(): Response<ApiResponse>
}