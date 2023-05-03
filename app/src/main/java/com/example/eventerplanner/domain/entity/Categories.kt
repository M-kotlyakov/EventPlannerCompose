package com.example.eventerplanner.domain.entity

data class Categories(
    val nameCategories: String,
    val eventItem: List<EventItem> = emptyList()
)
