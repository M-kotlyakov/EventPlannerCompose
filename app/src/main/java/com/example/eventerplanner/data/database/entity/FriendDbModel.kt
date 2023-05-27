package com.example.eventerplanner.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.eventerplanner.domain.entity.User

@Entity(
//    tableName = "friends",
//    foreignKeys = [
//        ForeignKey(entity = User::class,
//        parentColumns = ["id"],
//        childColumns = ["userId"],
//        onDelete = ForeignKey.CASCADE)
//    ],
//    primaryKeys = ["userId", "friendId"]
)
data class FriendDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "friendId") val friendId: Int
)
