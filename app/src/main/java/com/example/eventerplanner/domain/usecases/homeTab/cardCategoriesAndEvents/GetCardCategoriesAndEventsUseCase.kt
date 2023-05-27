package com.example.eventerplanner.domain.usecases.homeTab.cardCategoriesAndEvents

import com.example.eventerplanner.data.mapper.CardCategoriesAndEventsListMapper
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import com.example.eventerplanner.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCardCategoriesAndEventsUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: CardCategoriesAndEventsListMapper
) {

    operator fun invoke(): Flow<List<CardCategoriesAndEvents>> = flow { }
//        homeRepository.getCardCategoriesAndEventList().map { item ->
//            mapper.mapListDbModelToEntity(item)
//        }
}