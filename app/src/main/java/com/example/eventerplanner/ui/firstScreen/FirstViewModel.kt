package com.example.eventerplanner.ui.firstScreen

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class FirstViewModel @Inject constructor():
    ContainerHost<FirstState, FirstSideEffect>,
    ViewModel() {

    override val container = container<FirstState, FirstSideEffect>(FirstState())
}