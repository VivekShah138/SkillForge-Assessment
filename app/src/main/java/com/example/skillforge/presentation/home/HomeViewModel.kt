package com.example.skillforge.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillforge.domain.usecase.usecase_wrapper.HomeScreenUseCaseWrapper
import com.example.skillforge.utils.Logger
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
        getData()
    }

    fun onEvent(events: HomeEvents) {
        when (events) {
            else -> TODO("Handle actions")
        }
    }

    fun getData() {
        viewModelScope.launch {
            val result = homeScreenUseCaseWrapper.getCategoriesRemoteUseCase()

            result.onSuccess { categoryList ->
                categoryList.forEach { categoryModel ->
                    val allCourses = homeScreenUseCaseWrapper.getCoursesFromCategoriesUseCase(
                        categories = categoryList
                    )
                    _state.update {
                        it.copy(
                            categoryList = categoryList,
                            courseList = allCourses
                        )
                    }

                    Logger.d(Logger.Tag.HOME_VIEWMODEL, "categoryModel => $categoryModel")
                    Logger.d(Logger.Tag.HOME_VIEWMODEL, "allCourse => $allCourses")


                }
            }.onFailure { error ->
                Logger.e(Logger.Tag.HOME_VIEWMODEL, "Error => ${error.localizedMessage}")
            }
        }
    }
}