package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_categories")
data class CardCategoriesDbModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "event_id") val eventId: Int
)
