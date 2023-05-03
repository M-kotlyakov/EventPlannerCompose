package com.example.eventerplanner.data.database.dao

import androidx.room.Dao
import com.example.eventerplanner.data.database.entity.EventDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

//    suspend fun getListEvents(): Flow<List<EventDbModel>>
}