package com.example.eventerplanner.ui.auth.signIn

sealed class SignInSideEffect {

    object NavigateToHome   : SignInSideEffect()
    object NavigateToSignUp : SignInSideEffect()
}