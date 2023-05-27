package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.eventerplanner.domain.entity.User

@Entity(
//    tableName = "chat",
//    foreignKeys = [
//        ForeignKey(
//            entity = User::class,
//            parentColumns = ["id"],
//            childColumns = ["senderId"],
//            onDelete = ForeignKey.CASCADE
//        ),
//        ForeignKey(
//            entity = User::class,
//            parentColumns = ["id"],
//            childColumns = ["receivedId"],
//            onDelete = ForeignKey.CASCADE
//        )
//    ]
)
data class ChatDbModel(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "senderId") val senderId: Int,
    @ColumnInfo(name = "receivedId") val receivedId: Int,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long
)