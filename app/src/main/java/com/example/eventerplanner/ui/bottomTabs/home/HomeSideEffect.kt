package com.example.eventerplanner.ui.bottomTabs.home

import com.example.eventerplanner.domain.entity.Event

sealed class HomeSideEffect {
    data class AddEvent(val event: Event) : HomeSideEffect()
    data class ShowDetailEvent(val id: Int) : HomeSideEffect()
    object ShowDetailCategories : HomeSideEffect()
}