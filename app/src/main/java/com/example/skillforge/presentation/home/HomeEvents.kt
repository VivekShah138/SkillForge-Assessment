package com.example.skillforge.presentation.home

sealed interface HomeEvents {
   data object OnClickRetry: HomeEvents
   data class OnValueSearch(val searchQuery: String): HomeEvents
}