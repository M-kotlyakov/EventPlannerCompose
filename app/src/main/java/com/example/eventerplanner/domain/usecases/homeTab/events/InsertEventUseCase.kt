package com.example.eventerplanner.domain.usecases.homeTab.events

import com.example.eventerplanner.data.mapper.EventListMapper
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.repository.IRepository
import javax.inject.Inject

class InsertEventUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: EventListMapper
) {

    suspend operator fun invoke(event: Event) {
        homeRepository.insertEvent(mapper.mapEntityToDbModel(event))
    }
}