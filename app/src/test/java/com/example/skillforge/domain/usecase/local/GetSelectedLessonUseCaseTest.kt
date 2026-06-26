package com.example.skillforge.domain.usecase.local

import com.example.skillforge.domain.model.LessonModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetSelectedLessonUseCaseTest {

    private lateinit var useCase: GetSelectedLessonUseCase

    @Before
    fun setup() {
        useCase = GetSelectedLessonUseCase()
    }

    @Test
    fun `invoke returns selected lesson when lesson exists`() {
        val lessonList = listOf(
            LessonModel(
                id = "1",
                title = "Introduction",
                durationMinutes = 10,
                isFree = true,
                videoUrl = "video1",
                content = "content1"
            ),
            LessonModel(
                id = "2",
                title = "Advanced Topic",
                durationMinutes = 20,
                isFree = false,
                videoUrl = "video2",
                content = "content2"
            )
        )

        val result = useCase(
            lessonList = lessonList,
            lessonId = "2"
        )

        Assert.assertNotNull(result)
        Assert.assertEquals(1, result?.index)
        Assert.assertEquals("2", result?.lesson?.id)
        Assert.assertEquals("Advanced Topic", result?.lesson?.title)
    }

    @Test
    fun `invoke returns null when lesson does not exist`() {
        val lessonList = listOf(
            LessonModel(
                id = "1",
                title = "Introduction",
                durationMinutes = 10,
                isFree = true,
                videoUrl = "video1",
                content = "content1"
            )
        )

        val result = useCase(
            lessonList = lessonList,
            lessonId = "999"
        )

        Assert.assertNull(result)
    }
}