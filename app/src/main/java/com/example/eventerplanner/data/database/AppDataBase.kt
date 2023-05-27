package com.example.eventerplanner.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.eventerplanner.data.converters.EventConverters
import com.example.eventerplanner.data.database.dao.CardCategoriesAndEventsDao
import com.example.eventerplanner.data.database.dao.CardCategoriesDao
import com.example.eventerplanner.data.database.dao.ChatDao
import com.example.eventerplanner.data.database.dao.EventDao
import com.example.eventerplanner.data.database.dao.UserDao
import com.example.eventerplanner.data.database.entity.CardCategoriesDbModel
import com.example.eventerplanner.data.database.entity.ChatDbModel
import com.example.eventerplanner.data.database.entity.EventDbModel
import com.example.eventerplanner.data.database.entity.FriendDbModel
import com.example.eventerplanner.data.database.entity.UserDbModel

@Database(entities = [
    EventDbModel::class,
    UserDbModel::class,
    CardCategoriesDbModel::class,
//    CardCategoriesAndEventsDbModel::class,
    ChatDbModel::class,
    FriendDbModel::class],
    version = 2,
    exportSchema = false)
@TypeConverters(EventConverters::class)
abstract class AppDataBase: RoomDatabase() {

    abstract fun eventDao(): EventDao
    abstract fun cardCategoriesDao(): CardCategoriesDao
    abstract fun chatDao(): ChatDao
    abstract fun userDao(): UserDao
    abstract fun cardCategoriesAndEventDao(): CardCategoriesAndEventsDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "eventPlanner"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}