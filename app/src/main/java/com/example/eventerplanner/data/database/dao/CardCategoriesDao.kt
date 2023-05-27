package com.example.eventerplanner.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eventerplanner.data.database.entity.CardCategoriesDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CardCategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardCategories(cardCategories: CardCategoriesDbModel)

    @Query("DELETE FROM card_categories where cardCategoriesId =:id")
    suspend fun removeCardCategories(id: Int)

    @Query("SELECT * FROM card_categories")
    fun getCardCategoriesList(): Flow<List<CardCategoriesDbModel>>
}