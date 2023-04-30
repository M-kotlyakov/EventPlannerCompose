package com.example.eventerplanner.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.eventerplanner.data.database.entity.UserDbModel

@Dao
interface UserDao {

    @Query("SELECT * FROM user_items WHERE id =:userId")
    suspend fun getUser(userId: Int): UserDbModel
}