package com.example.eventerplanner.data.repository

import com.example.eventerplanner.data.database.dao.CardCategoriesAndEventsDao
import com.example.eventerplanner.data.database.dao.CardCategoriesDao
import com.example.eventerplanner.data.database.dao.EventDao
import com.example.eventerplanner.data.database.entity.CardCategoriesDbModel
import com.example.eventerplanner.data.database.entity.EventDbModel
import com.example.eventerplanner.data.mapper.CardCategoriesListMapper
import com.example.eventerplanner.data.mapper.EventListMapper
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import com.example.eventerplanner.domain.entity.Chat
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.entity.Friends
import com.example.eventerplanner.domain.entity.User
import com.example.eventerplanner.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class IRepositoryImpl @Inject constructor(
    private val cardCategoriesAndEventsDao: CardCategoriesAndEventsDao,
    private val cardCategoriesDao: CardCategoriesDao,
    private val eventDao: EventDao
): IRepository.IHome,
    IRepository.IFriend,
    IRepository.IChat,
    IRepository.IProfile {

    /**
     * HOME
    * */
//    override fun getCardCategoriesAndEventList(): Flow<List<CardCategoriesAndEventsDbModel>> {
//        return cardCategoriesAndEventsDao.getCardCategoriesEndEvents()
//    }

    override fun getCardCategoriesList(): Flow<List<CardCategoriesDbModel>> {
        return cardCategoriesDao.getCardCategoriesList()
    }

    override fun getEventsList(): Flow<List<EventDbModel>> {
        return eventDao.getEventList()
    }

    /*override suspend fun insertCardCategoriesAndEvents(cardCategoriesAndEventsDbModel: CardCategoriesAndEventsDbModel) {
    // TODO: пока просто оставить так, потом сделаю как надо
    //        cardCategoriesAndEventsDao.insertCardCategoriesAndEvents(cardCategoriesAndEventsDbModel)
    }*/

    override suspend fun insertEvent(event: EventDbModel) {
        eventDao.insertEvent(event)
    }

    override suspend fun insertCategories(cardCategories: CardCategoriesDbModel) {
        cardCategoriesDao.insertCardCategories(cardCategories)
    }

    override suspend fun removeEvent(eventId: Int) {
        eventDao.removeEvent(eventId)
    }

    override suspend fun removeCardCategories(id: Int) {
        cardCategoriesDao.removeCardCategories(id)
    }


    /**
     * FRIENDS
     * */
    override fun getAllFriends(): Flow<List<Friends>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertFriend(friend: Friends) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFriend(friendId: Int) {
        TODO("Not yet implemented")
    }

    /**
     * CHAT
     * */
    override fun getAllChats(): Flow<List<Chat>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertChat(chat: Chat) {
        TODO("Not yet implemented")
    }

    override suspend fun removeChat(chatId: Int) {
        TODO("Not yet implemented")
    }

    /**
     * PROFILE
     * */
    override suspend fun updateProfile(user: User) {
        TODO("Not yet implemented")
    }
}