package com.example.skillforge.utils.events

import com.example.skillforge.domain.model.data_model.ErrorType

interface UiEvents {
    data object NormalScreen: UiEvents
    data object IsLoading: UiEvents
    data object NoInternet: UiEvents
    data object Error: UiEvents
}