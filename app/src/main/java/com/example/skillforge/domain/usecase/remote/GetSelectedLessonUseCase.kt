package com.example.skillforge.domain.usecase.remote

import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.domain.model.data_model.SelectedLesson

class GetSelectedLessonUseCase {

    operator fun invoke(
        lessonList: List<LessonModel>,
        lessonId: String
    ): SelectedLesson? {

        val index = lessonList.indexOfFirst { it.id == lessonId }

        if (index == -1) return null

        return SelectedLesson(
            lesson = lessonList[index],
            index = index
        )
    }
}