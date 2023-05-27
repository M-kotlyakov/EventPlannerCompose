package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_items")
data class EventDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "categoriesParentId") val categoriesParentId: Int,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "startDateTime") val startDateTime: String,
    @ColumnInfo(name = "endDateTime") val endDateTime: String,
    @ColumnInfo(name = "responsibility") val responsibility: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "weatherCelsius") val weatherCelsius: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "attachedFiles") val attachedFiles: String
)
