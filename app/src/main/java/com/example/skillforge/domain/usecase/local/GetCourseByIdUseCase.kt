package com.example.skillforge.domain.usecase.local

import com.example.skillforge.domain.model.CourseModel

class GetCourseByIdUseCase {

    operator fun invoke(
        courseList: List<CourseModel>,
        courseId: String
    ): CourseModel? {
        return courseList.find { it.id == courseId }
    }
}