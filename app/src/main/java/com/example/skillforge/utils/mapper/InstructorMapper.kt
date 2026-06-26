package com.example.skillforge.utils.mapper

import com.example.skillforge.domain.model.InstructorModel
import com.example.skillforge.domain.dto_response.InstructorResponse

fun InstructorResponse.toInstructorModel(): InstructorModel {
    return InstructorModel(
        id = id,
        name = name,
        title = title,
        avatarUrl = avatarUrl,
        bio = bio
    )
}