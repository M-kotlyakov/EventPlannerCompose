package com.example.eventerplanner.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.eventerplanner.ui.MainActivity
import com.example.eventerplanner.ui.bottomTabs.chat.ChatFragment
import com.example.eventerplanner.ui.bottomTabs.chat.detailChat.DetailChatFragment
import com.example.eventerplanner.ui.bottomTabs.friends.FriendsFragment
import com.example.eventerplanner.ui.bottomTabs.home.HomeFragment
import com.example.eventerplanner.ui.bottomTabs.home.detailCategories.DetailCategoriesFragment
import com.example.eventerplanner.ui.bottomTabs.home.detailEvent.DetailEventFragment
import com.example.eventerplanner.ui.bottomTabs.home.noEditEvent.NoEditEventCard
import com.example.eventerplanner.ui.bottomTabs.profile.ProfileFragment
import com.example.eventerplanner.ui.bottomTabs.profile.editProfile.EditProfileFragment
import com.example.eventerplanner.ui.fail.FailFragment
import com.example.eventerplanner.ui.firstScreen.FirstFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [ViewModelModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(chatFragment: ChatFragment)
    fun inject(friendFragment: FriendsFragment)
    fun inject(profileFragment: ProfileFragment)
    fun inject(detailFragment: DetailChatFragment)
    fun inject(detailCategoriesFragment: DetailCategoriesFragment)
    fun inject(detailEventFragment: DetailEventFragment)
    fun inject(noEditEventCard: NoEditEventCard)
    fun inject(editProfileFragment: EditProfileFragment)
    fun inject(failFragment: FailFragment)
    fun inject(firstFragment: FirstFragment)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}