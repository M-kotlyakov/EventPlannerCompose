package com.example.eventerplanner.ui.bottomTabs.profile

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class ProfileViewModel @Inject constructor():
    ContainerHost<ProfileState, ProfileSideEffect>,
    ViewModel() {

    override val container = container<ProfileState, ProfileSideEffect>(
        ProfileState()
    )
}