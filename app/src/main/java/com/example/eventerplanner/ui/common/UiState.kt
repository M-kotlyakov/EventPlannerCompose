package com.example.eventerplanner.ui.common

sealed class UiState {

    data class Success(val message: String) : UiState()
    object Loading : UiState()
    object Failed : UiState()
}
