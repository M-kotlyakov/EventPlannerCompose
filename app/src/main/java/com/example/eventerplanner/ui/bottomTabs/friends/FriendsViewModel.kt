package com.example.eventerplanner.ui.bottomTabs.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class FriendsViewModel @Inject constructor():
    ContainerHost<FriendsState, FriendsSideEffect>,
    ViewModel() {

    override val container = container<FriendsState, FriendsSideEffect>(
        FriendsState()
    )
}