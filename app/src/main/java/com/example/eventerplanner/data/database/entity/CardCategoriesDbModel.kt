package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_categories")
data class CardCategoriesDbModel(
    @PrimaryKey(autoGenerate = true) val cardCategoriesId: Int,
    @ColumnInfo(name = "categoriesName") val categoriesName: String,
    @ColumnInfo(name = "countOfEvents") val countOfEvents: Int,
    @ColumnInfo(name = "eventList") val eventList: List<EventDbModel>
)
