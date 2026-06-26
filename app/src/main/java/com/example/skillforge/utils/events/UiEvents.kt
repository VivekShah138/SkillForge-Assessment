package com.example.skillforge.utils.events

interface UiEvents {
    data object NormalScreen: UiEvents
    data object IsLoading: UiEvents
    data object NoInternet: UiEvents
    data object Error: UiEvents
}