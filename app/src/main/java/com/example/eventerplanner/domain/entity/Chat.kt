package com.example.eventerplanner.domain.entity

data class Chat(
    val id: Int,
    val friend: List<Friend> = emptyList(),
    val messages: List<Messages> = emptyList(),
    val unreadMessages: Int
)
