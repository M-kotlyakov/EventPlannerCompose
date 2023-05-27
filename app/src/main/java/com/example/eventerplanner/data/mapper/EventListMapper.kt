package com.example.eventerplanner.data.mapper

import com.example.eventerplanner.data.database.entity.EventDbModel
import com.example.eventerplanner.domain.entity.Event
import javax.inject.Inject

class EventListMapper @Inject constructor() {

    fun mapEntityToDbModel(event: Event) = EventDbModel(
        id = event.id,
        categoriesParentId = event.categoriesParentId,
        address = event.address,
        startDateTime = event.startDateTime,
        endDateTime = event.endDateTime,
        responsibility = event.responsibility,
        status = event.status,
        weatherCelsius = event.weatherCelsius,
        description = event.description,
        attachedFiles = event.attachedFiles
    )

    fun mapDbModelToEntity(eventDbModel: EventDbModel) = Event(
        id = eventDbModel.id,
        categoriesParentId = eventDbModel.categoriesParentId,
        address = eventDbModel.address,
        startDateTime = eventDbModel.startDateTime,
        endDateTime = eventDbModel.endDateTime,
        responsibility = eventDbModel.responsibility,
        status = eventDbModel.status,
        weatherCelsius = eventDbModel.weatherCelsius,
        description = eventDbModel.description,
        attachedFiles = eventDbModel.attachedFiles
    )

    fun mapListDbModelToListEntity(list: List<EventDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListEntityToDbModel(list: List<Event>) = list.map {
        mapEntityToDbModel(it)
    }
}