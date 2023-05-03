package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat")
data class ChatDbModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "messages") val message: Int,
    @ColumnInfo(name = "userId") val userId: Int
)