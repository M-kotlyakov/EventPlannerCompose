package com.example.eventerplanner.ui.bottomTabs.chat

import com.example.eventerplanner.domain.entity.Chat

sealed class ChatSideEffect {
    data class AddChat(val newChat: Chat) : ChatSideEffect()
    data class ShowDetailChat(val id: Int) : ChatSideEffect()
}