package com.example.eventerplanner.data.converters

import androidx.room.TypeConverter
import com.example.eventerplanner.data.database.entity.EventDbModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EventConverters {

    @TypeConverter
    fun toString(eventDbModels: List<EventDbModel>): String {
        return Gson().toJson(eventDbModels)
    }

    @TypeConverter
    fun fromString(value: String): List<EventDbModel> {
        val type = object : TypeToken<List<EventDbModel>>() {}.type
        return Gson().fromJson(value, type)
    }
}