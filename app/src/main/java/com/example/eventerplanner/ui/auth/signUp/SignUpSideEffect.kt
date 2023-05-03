package com.example.eventerplanner.ui.auth.signUp

sealed class SignUpSideEffect {

    object NavigateToNextStep : SignUpSideEffect()
    object NavigateToHome     : SignUpSideEffect()
    object NavigateToSignIn   : SignUpSideEffect()
}