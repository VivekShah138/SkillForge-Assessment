package com.example.skillforge.domain.usecase.local

import com.example.skillforge.domain.model.LessonModel
import com.example.skillforge.domain.model.SelectedLesson

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