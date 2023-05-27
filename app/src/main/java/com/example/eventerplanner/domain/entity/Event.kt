package com.example.eventerplanner.domain.entity

import androidx.room.ColumnInfo

data class Event(
    val id: Int = 0,
    val categoriesParentId: Int = 0,
    val address: String = "",
    val startDateTime: String = "",
    val endDateTime: String = "",
    val responsibility: String = "",
    val status: String = "",
    val weatherCelsius: Int = 0,
    val description: String = "",
    val attachedFiles: String = ""
)
