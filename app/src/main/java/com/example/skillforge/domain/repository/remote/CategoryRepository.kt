package com.example.skillforge.domain.repository.remote

import com.example.skillforge.domain.model.data_model.CategoryModel

interface CategoryRepository {
    suspend fun getAllCategories(): Result<List<CategoryModel>>
}