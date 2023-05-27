package com.example.eventerplanner.domain.entity

import com.example.eventerplanner.data.database.entity.EventDbModel

data class CardCategories(
    val cardCategoriesId: Int = 0,
    val categoriesName: String = "event",
    val countOfEvents: Int = 0,
    val eventList: List<Event> = emptyList()
)
