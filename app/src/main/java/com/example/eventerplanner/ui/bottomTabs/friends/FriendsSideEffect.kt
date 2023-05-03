package com.example.eventerplanner.ui.bottomTabs.friends

sealed class FriendsSideEffect {
    data class AddFriend(val friendId: Int) : FriendsSideEffect()
}