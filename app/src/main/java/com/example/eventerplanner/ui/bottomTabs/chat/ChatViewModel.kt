package com.example.eventerplanner.ui.bottomTabs.chat

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class ChatViewModel @Inject constructor() :
    ContainerHost<ChatState, ChatSideEffect>,
    ViewModel() {

    override val container = container<ChatState, ChatSideEffect>(ChatState())
}