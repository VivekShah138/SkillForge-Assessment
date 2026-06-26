package com.example.skillforge.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.NetworkStatus
import com.example.skillforge.domain.usecase.usecase_wrapper.HomeScreenUseCaseWrapper
import com.example.skillforge.utils.Logger
import com.example.skillforge.utils.events.HomeScreenUiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenUseCaseWrapper: HomeScreenUseCaseWrapper
) : ViewModel() {

    private val _state = MutableStateFlow(HomeStates())
    val state: StateFlow<HomeStates> = _state.asStateFlow()

    init {
        monitorNetwork()
    }

    fun onEvent(events: HomeEvents) {
        when (events) {
            HomeEvents.OnClickRetry -> {
                monitorNetwork()
            }

            is HomeEvents.OnValueSearch -> {
                _state.update { it.copy(searchValue = events.searchQuery) }
                filterValuesOnSearch(searchQuery = events.searchQuery)

            }
        }
    }

    private fun monitorNetwork() {
        viewModelScope.launch {
            homeScreenUseCaseWrapper.networkMonitorLocalUseCase().collect { status ->
                if (status == NetworkStatus.Available) {
                    getData()
                } else {
                    _state.update { it.copy(homeScreenUiEvents = HomeScreenUiEvents.NoInternet) }
                }
            }
        }
    }

    private suspend fun getData() {
        _state.update { it.copy(homeScreenUiEvents = HomeScreenUiEvents.Loading) }
        val result = homeScreenUseCaseWrapper.getCategoriesRemoteUseCase()

        result.onSuccess { categoryList ->
            categoryList.forEach { categoryModel ->
                val allCourses = homeScreenUseCaseWrapper.getCoursesFromCategoriesUseCase(
                    categories = categoryList
                )
                _state.update {
                    it.copy(
                        categoryList = categoryList,
                        courseList = allCourses,
                        filteredCourseList = allCourses,
                        filteredCategoryList = categoryList
                    )
                }

                Logger.d(Logger.Tag.HOME_VIEWMODEL, "categoryModel => $categoryModel")
                Logger.d(Logger.Tag.HOME_VIEWMODEL, "allCourse => $allCourses")

                _state.update { it.copy(homeScreenUiEvents = HomeScreenUiEvents.Success) }
            }
        }.onFailure { error ->
            Logger.e(Logger.Tag.HOME_VIEWMODEL, "Error => ${error.localizedMessage}")
            _state.update { it.copy(homeScreenUiEvents = HomeScreenUiEvents.Error) }
        }
    }

    private fun filterValuesOnSearch(searchQuery: String) {
        val query = searchQuery.trim()

        if (query.isBlank()) {
            _state.update {
                it.copy(
                    filteredCategoryList = it.categoryList,
                    filteredCourseList = it.courseList
                )
            }
            return
        }

        val currentState = _state.value

        val filteredCategories = filterCategoriesOnNameAndCourses(
            currentState.categoryList,
            query = query
        )

        val filteredCourses = filterCourseList(
            courseList = currentState.courseList,
            query = query
        )

        _state.update {
            it.copy(
                filteredCategoryList = filteredCategories,
                filteredCourseList = filteredCourses
            )
        }
    }


    private fun filterCategoriesOnNameAndCourses(
        categoryList: List<CategoryModel>,
        query: String
    ): List<CategoryModel> {
        return categoryList.filter { category ->
            // Match category name
            category.name.contains(query, ignoreCase = true) ||

                    // OR match any course inside category
                    category.courses.any { course ->
                        course.title.contains(query, ignoreCase = true) ||
                                course.tags.any { tag ->
                                    tag.contains(query, ignoreCase = true)
                                }
                    }
        }
    }

    private fun filterCourseList(
        courseList: List<CourseModel>, query: String
    ): List<CourseModel> {
        return courseList.filter { course ->
            course.title.contains(query, ignoreCase = true) ||
                    course.tags.any { tag ->
                        tag.contains(query, ignoreCase = true)
                    }
        }
    }
}