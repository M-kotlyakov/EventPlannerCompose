package com.example.eventerplanner.di

import android.app.Application
import com.example.eventerplanner.data.database.AppDataBase
import com.example.eventerplanner.data.database.dao.CardCategoriesAndEventsDao
import com.example.eventerplanner.data.database.dao.CardCategoriesDao
import com.example.eventerplanner.data.database.dao.ChatDao
import com.example.eventerplanner.data.database.dao.EventDao
import com.example.eventerplanner.data.database.dao.UserDao
import com.example.eventerplanner.data.repository.IRepositoryImpl
import com.example.eventerplanner.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindIHome(impl: IRepositoryImpl): IRepository.IHome

    @ApplicationScope
    @Binds
    fun bindIFriend(impl: IRepositoryImpl): IRepository.IFriend

    @ApplicationScope
    @Binds
    fun bindIChat(impl: IRepositoryImpl): IRepository.IChat

    @ApplicationScope
    @Binds
    fun bindIProfile(impl: IRepositoryImpl): IRepository.IProfile

    companion object {

        @ApplicationScope
        @Provides
        fun provideEventDao(
            application: Application
        ): EventDao {
            return AppDataBase.getInstance(application).eventDao()
        }

        @ApplicationScope
        @Provides
        fun provideCardCategoriesAndEventsDao(
            application: Application
        ): CardCategoriesAndEventsDao {
            return AppDataBase.getInstance(application).cardCategoriesAndEventDao()
        }

        @ApplicationScope
        @Provides
        fun provideCardCategoriesDao(
            application: Application
        ): CardCategoriesDao {
            return AppDataBase.getInstance(application).cardCategoriesDao()
        }

        @ApplicationScope
        @Provides
        fun provideChatDao(
            application: Application
        ): ChatDao {
            return AppDataBase.getInstance(application).chatDao()
        }

        @ApplicationScope
        @Provides
        fun provideUserDao(
            application: Application
        ): UserDao {
            return AppDataBase.getInstance(application).userDao()
        }
    }
}