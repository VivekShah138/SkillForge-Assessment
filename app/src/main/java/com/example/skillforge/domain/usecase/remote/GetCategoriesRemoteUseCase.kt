package com.example.skillforge.domain.usecase.remote

import com.example.skillforge.domain.model.data_model.CategoryModel
import com.example.skillforge.domain.repository.remote.CategoryRepository
import javax.inject.Inject

class GetCategoriesRemoteUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {

    suspend operator fun invoke(): Result<List<CategoryModel>> {
        return categoryRepository.getAllCategories()
    }
}