package com.example.eventerplanner.ui.bottomTabs.home

import com.example.eventerplanner.domain.entity.Categories
import com.example.eventerplanner.domain.entity.EventItem

data class HomeState(
    val categories: List<Categories> = emptyList(),
    val events: List<EventItem> = emptyList(),
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