package com.example.eventerplanner.di

import androidx.lifecycle.ViewModel
import com.example.eventerplanner.ui.auth.signIn.SignInViewModel
import com.example.eventerplanner.ui.auth.signUp.SignUpViewModel
import com.example.eventerplanner.ui.bottomTabs.chat.ChatViewModel
import com.example.eventerplanner.ui.bottomTabs.chat.detailChat.DetailChatViewModel
import com.example.eventerplanner.ui.bottomTabs.friends.FriendsViewModel
import com.example.eventerplanner.ui.bottomTabs.home.HomeViewModel
import com.example.eventerplanner.ui.bottomTabs.home.detailCategories.DetailCategoriesViewModel
import com.example.eventerplanner.ui.bottomTabs.home.detailEvent.DetailEventViewModel
import com.example.eventerplanner.ui.bottomTabs.profile.ProfileViewModel
import com.example.eventerplanner.ui.firstScreen.FirstViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    /**
     * FIRST_SCREEN
     **/
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    @Binds
    fun bindFirstViewModel(impl: FirstViewModel): ViewModel

    /**
     * AUTH
     **/
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    @Binds
    fun bindSignUpViewModel(impl: SignUpViewModel): ViewModel

    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    @Binds
    fun bindSignInViewModel(impl: SignInViewModel): ViewModel

    /**
     * BOTTOM_TABS
     **/
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    @Binds
    fun bindHomeViewModel(impl: HomeViewModel): ViewModel

    @IntoMap
    @ViewModelKey(DetailCategoriesViewModel::class)
    @Binds
    fun bindDetailCategoriesViewModel(impl: DetailCategoriesViewModel): ViewModel

    @IntoMap
    @ViewModelKey(DetailEventViewModel::class)
    @Binds
    fun bindDetailEventViewModel(impl: DetailEventViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    @Binds
    fun bindProfileViewModel(impl: ProfileViewModel): ViewModel

    @IntoMap
    @ViewModelKey(FriendsViewModel::class)
    @Binds
    fun bindFriendsViewModel(impl: FriendsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    @Binds
    fun bindChatViewModel(impl: ChatViewModel): ViewModel

    @IntoMap
    @ViewModelKey(DetailChatViewModel::class)
    @Binds
    fun bindDetailChatViewModel(impl: DetailChatViewModel): ViewModel
}