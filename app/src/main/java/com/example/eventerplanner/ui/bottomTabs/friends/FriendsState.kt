package com.example.eventerplanner.ui.bottomTabs.friends

import com.example.eventerplanner.domain.entity.User

data class FriendsState(
    val friends: List<User> = emptyList(),
    val searchFriend: String = ""
)