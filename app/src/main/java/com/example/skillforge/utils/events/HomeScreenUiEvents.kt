package com.example.skillforge.utils.events

interface HomeScreenUiEvents {
    data object Success: HomeScreenUiEvents
    data object Loading: HomeScreenUiEvents
    data object NoInternet: HomeScreenUiEvents
    data object Error: HomeScreenUiEvents
}