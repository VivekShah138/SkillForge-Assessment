package com.example.skillforge.domain.usecase.remote

import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.repository.remote.CategoryRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetCategoriesRemoteUseCaseTest {

    private lateinit var repository: CategoryRepository
    private lateinit var useCase: GetCategoriesRemoteUseCase

    @Before
    fun setup() {
        repository = mock()
        useCase = GetCategoriesRemoteUseCase(repository)
    }

    @Test
    fun `invoke returns category list when repository succeeds`() = runTest {
        val categories = listOf(
            CategoryModel(
                id = "1",
                name = "Android",
                description = "Android Development",
                iconColor = "#00FF00",
                courseCount = 10,
                courses = emptyList()
            ),
            CategoryModel(
                id = "2",
                name = "Backend",
                description = "Backend Development",
                iconColor = "#0000FF",
                courseCount = 8,
                courses = emptyList()
            )
        )

        whenever(repository.getAllCategories())
            .thenReturn(Result.success(categories))

        val result = useCase()

        assertTrue(result.isSuccess)
        assertEquals(categories, result.getOrNull())
    }

    @Test
    fun `invoke returns failure when repository fails`() = runTest {
        val exception = Exception("Network error")

        whenever(repository.getAllCategories())
            .thenReturn(Result.failure(exception))

        val result = useCase()

        assertTrue(result.isFailure)
        assertEquals(
            "Network error",
            result.exceptionOrNull()?.message
        )
    }
}