package com.example.skillforge.domain.usecase.remote

import com.example.skillforge.domain.model.data_model.CourseModel

class GetCourseByIdUseCase {

    operator fun invoke(
        courseList: List<CourseModel>,
        courseId: String
    ): CourseModel? {
        return courseList.find { it.id == courseId }
    }
}