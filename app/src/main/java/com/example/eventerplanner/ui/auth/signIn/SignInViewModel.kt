package com.example.eventerplanner.ui.auth.signIn

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class SignInViewModel @Inject constructor() :
    ContainerHost<SignInState, SignInSideEffect>,
    ViewModel() {

    override val container = container<SignInState, SignInSideEffect>(SignInState())
}