package com.example.eventerplanner.domain.entity

data class CardCategoriesAndEvents(
    val id: Int = 0,
    val cardCategories: CardCategories,
    val eventList: List<Event>
)
