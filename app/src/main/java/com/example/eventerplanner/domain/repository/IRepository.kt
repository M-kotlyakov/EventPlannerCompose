package com.example.eventerplanner.domain.repository

import com.example.eventerplanner.data.database.entity.CardCategoriesDbModel
import com.example.eventerplanner.data.database.entity.EventDbModel
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import com.example.eventerplanner.domain.entity.Chat
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.entity.Friends
import com.example.eventerplanner.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface IRepository {

    interface IHome {

//        fun getCardCategoriesAndEventList(): Flow<List<CardCategoriesAndEventsDbModel>>

        fun getEventsList(): Flow<List<EventDbModel>>

        fun getCardCategoriesList(): Flow<List<CardCategoriesDbModel>>

//        suspend fun insertCardCategoriesAndEvents(cardCategoriesAndEventsDbModel: CardCategoriesAndEventsDbModel)

        suspend fun insertEvent(event: EventDbModel)

        suspend fun insertCategories(cardCategories: CardCategoriesDbModel)

        suspend fun removeEvent(eventId: Int)

        suspend fun removeCardCategories(id: Int)

        //        suspend fun getEventById(eventId: Int): Event
    }

    interface IFriend {

        fun getAllFriends(): Flow<List<Friends>>

        suspend fun insertFriend(friend: Friends)

        suspend fun removeFriend(friendId: Int)
    }

    interface IChat {

        fun getAllChats(): Flow<List<Chat>>

        suspend fun insertChat(chat: Chat)

        suspend fun removeChat(chatId: Int)
    }

    interface IProfile {

        suspend fun updateProfile(user: User)
    }
}