package com.example.eventerplanner.ui.bottomTabs.chat

import com.example.eventerplanner.domain.entity.Chat

data class ChatState(
    val chat: List<Chat> = emptyList(),
    val searchText: String = ""
)