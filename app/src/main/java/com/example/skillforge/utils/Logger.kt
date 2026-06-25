package com.example.skillforge.utils

import timber.log.Timber

object Logger {

    object Tag {
        const val HOME_VIEWMODEL = "HomeViewModel"
        const val COURSE_DETAILS_VIEWMODEL = "CourseDetailsViewModel"
        const val LESSON_VIEWMODEL = "LessonViewmodel"
    }

    fun d(tag: String, message: String) {
        val modifiedMessage = "$message\n\n\n"
        Timber.tag(tag).d(modifiedMessage)
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        val modifiedMessage = "$message\n\n\n"
        Timber.tag(tag).e(throwable, modifiedMessage)
    }
}