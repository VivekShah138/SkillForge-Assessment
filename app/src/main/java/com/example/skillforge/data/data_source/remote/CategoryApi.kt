package com.example.skillforge.data.data_source.remote

import com.example.skillforge.domain.model.response.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {

    @GET
    suspend fun getAllCategories(): List<CategoryResponse>
}