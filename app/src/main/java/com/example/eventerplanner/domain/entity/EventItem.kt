package com.example.eventerplanner.domain.entity

data class EventItem(
    val id: Int,
    val place: String,
    val startDateTime: String,
    val startDate: String,
    val endDateTime: String,
    val endDate: String,
    val responsibility: String,
    val status: String,
    val weatherCelsius: Int,
    val description: String,
    val attachedFiles: String
)
