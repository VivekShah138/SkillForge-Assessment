package com.example.skillforge.domain.model.data_model

enum class ErrorType(
    val heading: String,
    val errorMessage: String
) {
    NO_INTERNET(
        heading = "No Internet Connection",
        errorMessage = "Check your network and try again."
    ),
    GENERAL_ERROR(
        heading = "Something Went Wrong",
        errorMessage = "An unexpected error occurred. Please try again."
    )
}