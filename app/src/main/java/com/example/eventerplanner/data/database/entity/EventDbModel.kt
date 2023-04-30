package com.example.eventerplanner.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_items")
data class EventDbModel(
    @PrimaryKey(autoGenerate = true)
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
