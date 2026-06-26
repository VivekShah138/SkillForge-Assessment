package com.example.skillforge.presentation.home

import com.example.skillforge.presentation.home.components.FullSearchMode

sealed interface HomeEvents {
   data object OnClickRetry: HomeEvents
   data class OnValueSearch(val searchQuery: String): HomeEvents
   data object OnCancelClick: HomeEvents
   data class ChangeFullSearchMode(val state: Boolean, val type: FullSearchMode): HomeEvents
}