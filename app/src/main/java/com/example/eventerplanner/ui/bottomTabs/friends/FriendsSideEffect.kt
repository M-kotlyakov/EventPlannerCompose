package com.example.eventerplanner.ui.bottomTabs.friends

import com.example.eventerplanner.domain.entity.Friend

sealed class FriendsSideEffect {
    data class AddFriend(val friend: Friend) : FriendsSideEffect()
}