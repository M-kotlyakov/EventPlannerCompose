package com.example.eventerplanner.ui.bottomTabs.home

import com.example.eventerplanner.domain.entity.EventItem

sealed class HomeSideEffect {
    data class AddEvent(val event: EventItem) : HomeSideEffect()
    data class ShowDetailEvent(val id: Int) : HomeSideEffect()
    object ShowDetailCategories : HomeSideEffect()
}