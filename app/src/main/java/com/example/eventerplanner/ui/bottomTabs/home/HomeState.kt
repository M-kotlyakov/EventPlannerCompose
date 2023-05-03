package com.example.eventerplanner.ui.bottomTabs.home

import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.Event

data class HomeState(
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