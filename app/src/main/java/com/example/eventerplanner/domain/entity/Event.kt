package com.example.eventerplanner.domain.entity

import androidx.room.ColumnInfo

data class Event(
    val id: Int,
    val address: String,
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
