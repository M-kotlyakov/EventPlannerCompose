package com.example.eventerplanner.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eventerplanner.data.database.entity.EventDbModel
import com.example.eventerplanner.domain.entity.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM event_items")
    fun getEventList(): Flow<List<EventDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: EventDbModel)

    @Query("DELETE FROM event_items WHERE id =:eventId")
    suspend fun removeEvent(eventId: Int)
}