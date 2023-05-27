package com.example.eventerplanner.ui.bottomTabs.chat.detailChat

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class DetailChatViewModel @Inject constructor():
    ContainerHost<DetailChatState, DetailChatSideEffect>,
    ViewModel() {

    override val container = container<DetailChatState, DetailChatSideEffect>(
        DetailChatState()
    )
}