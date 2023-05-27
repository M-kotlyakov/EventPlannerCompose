package com.example.eventerplanner.ui.auth.signUp

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class SignUpViewModel @Inject constructor() :
    ContainerHost<SignUpState, SignUpSideEffect>,
    ViewModel() {

    override val container = container<SignUpState, SignUpSideEffect>(SignUpState())
}