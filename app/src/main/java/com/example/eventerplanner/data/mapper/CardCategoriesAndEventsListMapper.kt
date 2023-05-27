package com.example.eventerplanner.data.mapper

import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import javax.inject.Inject

class CardCategoriesAndEventsListMapper @Inject constructor(
    private val cardCategoriesMapper: CardCategoriesListMapper,
    private val eventMapper: EventListMapper
) {

   /* fun mapEntityToDbModel(
        cardCategoriesAndEvents: CardCategoriesAndEvents
    ) = CardCategoriesAndEventsDbModel(
        id = cardCategoriesAndEvents.id,
        cardCategoriesDbModel = cardCategoriesMapper.mapEntityToDbModel(cardCategoriesAndEvents.cardCategories),
        eventList = eventMapper.mapListEntityToDbModel(cardCategoriesAndEvents.eventList)
    )

    fun mapDbModelToEntity(
        cardCategoriesAndEventsDbModel: CardCategoriesAndEventsDbModel
    ) = CardCategoriesAndEvents (
        id = cardCategoriesAndEventsDbModel.id,
        cardCategories = cardCategoriesMapper.mapDbModelToEntity(cardCategoriesAndEventsDbModel.cardCategoriesDbModel),
        eventList = eventMapper.mapListDbModelToListEntity(cardCategoriesAndEventsDbModel.eventList)
    )

    fun mapListDbModelToEntity(list: List<CardCategoriesAndEventsDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListEntityToDbModel(list: List<CardCategoriesAndEvents>) = list.map {
        mapEntityToDbModel(it)
    }*/
}