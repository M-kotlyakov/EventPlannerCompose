package com.example.eventerplanner.domain.usecases.homeTab.cardCategoriesAndEvents

import com.example.eventerplanner.data.mapper.CardCategoriesAndEventsListMapper
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import com.example.eventerplanner.domain.repository.IRepository
import javax.inject.Inject

class InsertCardCategoriesAndEventsUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: CardCategoriesAndEventsListMapper
) {

    suspend operator fun invoke(cardCategoriesAndEvents: CardCategoriesAndEvents) {
//        homeRepository.insertCardCategoriesAndEvents(
//            mapper.mapEntityToDbModel(cardCategoriesAndEvents)
//        )
    }
}