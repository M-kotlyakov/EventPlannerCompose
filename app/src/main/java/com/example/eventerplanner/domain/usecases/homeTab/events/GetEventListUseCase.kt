package com.example.eventerplanner.domain.usecases.homeTab.events

import com.example.eventerplanner.data.mapper.EventListMapper
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetEventListUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: EventListMapper
) {
    operator fun invoke(): Flow<List<Event>> =
        homeRepository.getEventsList().map { event ->
            mapper.mapListDbModelToListEntity(event)
        }
}