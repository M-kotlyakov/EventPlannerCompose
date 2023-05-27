package com.example.eventerplanner.domain.usecases.homeTab.events

import com.example.eventerplanner.domain.repository.IRepository
import javax.inject.Inject

class RemoveEventUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome
) {

    suspend operator fun invoke(eventId: Int) {
        homeRepository.removeEvent(eventId)
    }
}