package com.example.skillforge.domain.repository.remote

import com.example.skillforge.domain.model.CategoryModel

interface CategoryRepository {
    suspend fun getAllCategories(): Result<List<CategoryModel>>
}