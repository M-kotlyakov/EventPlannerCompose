package com.example.eventerplanner.ui.bottomTabs.friends

import com.example.eventerplanner.domain.entity.Friend

data class FriendsState(
    val friends: List<Friend> = emptyList(),
    val searchFriend: String = ""
)