package com.example.eventerplanner.ui.bottomTabs.profile

sealed class ProfileSideEffect {

    object ShowDetailAttachment : ProfileSideEffect()
    object ShowDetailPrivacy    : ProfileSideEffect()
    object ShowDetailLanguage   : ProfileSideEffect()
    object ShowDetailAboutApp   : ProfileSideEffect()
}