package com.example.eventerplanner.ui.bottomTabs.home

import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.ui.common.UiState

data class HomeState(
    val screenState: UiState = UiState.Success("Ok"),
    val categories: List<CardCategories> = emptyList(),
    val events: List<Event> = emptyList(),
    val sorted: Sort = Sort.EARLIER,
    val filter: Filter = Filter.ALL
) {
    enum class Sort {
        EARLIER,
        LATER
    }

    enum class Filter {
        ALL,
        STATUS,
        TIME,
        NAME,
        ADDRESS
    }
}

/*
sealed class HomeState {

    data class Success(val message: String) : HomeState()
    data class Loading(val message: String) : HomeState()
    data class Failed(val errorMessage: String) : HomeState()
}*/
