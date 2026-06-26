package com.example.skillforge.data.repository.remote

import com.example.skillforge.data.data_source.remote.CategoryApi
import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.repository.remote.CategoryRepository
import com.example.skillforge.utils.mapper.toCategoryModel
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi
) : CategoryRepository {
    override suspend fun getAllCategories(): Result<List<CategoryModel>> {
        return try {
            val response = categoryApi.getAllCategories()

            if (response.isSuccessful) {
                val categories = response.body()?.categories

                if (categories != null) {
                    Result.success(
                        categories.map { it.toCategoryModel() }
                    )
                } else {
                    Result.failure(Exception("Response body is null"))
                }
            } else {
                Result.failure(
                    Exception("API Error: ${response.code()} ${response.message()}")
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}