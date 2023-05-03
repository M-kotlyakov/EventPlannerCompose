package com.example.eventerplanner.domain.entity

data class UserItem(
    val id: Int,
    val imageAvatar: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val company: String,
    val jobTitle: String
)