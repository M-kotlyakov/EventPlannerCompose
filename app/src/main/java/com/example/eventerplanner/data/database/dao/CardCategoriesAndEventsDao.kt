package com.example.eventerplanner.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CardCategoriesAndEventsDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardCategoriesAndEvents(cardCategoriesAndEvents: CardCategoriesAndEventsDbModel)

    @Query("DELETE FROM card_categories_and_events WHERE id =:cardCategoriesAndEventsId")
    suspend fun removeCardCategoriesAndEvents(cardCategoriesAndEventsId: Int)

    @Transaction
    @Query("SELECT * FROM card_categories_and_events")
    fun getCardCategoriesEndEvents(): Flow<List<CardCategoriesAndEventsDbModel>>*/
}