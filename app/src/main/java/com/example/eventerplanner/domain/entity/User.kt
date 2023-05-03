package com.example.eventerplanner.domain.entity

import androidx.room.ColumnInfo

data class User(
    val id: Int,
    val imageUrl: String?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val company: String,
    val jobTitle: String
)