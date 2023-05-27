package com.example.eventerplanner.data.mapper

import com.example.eventerplanner.data.database.entity.CardCategoriesDbModel
import com.example.eventerplanner.domain.entity.CardCategories
import javax.inject.Inject

class CardCategoriesListMapper @Inject constructor(
    private val eventMapper: EventListMapper
) {

    fun mapEntityToDbModel(cardCategories: CardCategories) = CardCategoriesDbModel(
        cardCategoriesId = cardCategories.cardCategoriesId,
        categoriesName = cardCategories.categoriesName,
        countOfEvents = cardCategories.countOfEvents,
        eventList = eventMapper.mapListEntityToDbModel(cardCategories.eventList)
    )

    fun mapDbModelToEntity(cardCategoriesDbModel: CardCategoriesDbModel) = CardCategories(
        cardCategoriesId = cardCategoriesDbModel.cardCategoriesId,
        categoriesName = cardCategoriesDbModel.categoriesName,
        countOfEvents = cardCategoriesDbModel.countOfEvents,
        eventList = eventMapper.mapListDbModelToListEntity(cardCategoriesDbModel.eventList)
    )

    fun mapListDbModelToListEntity(list: List<CardCategoriesDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListEntityToDbModel(list: List<CardCategories>) = list.map {
        mapEntityToDbModel(it)
    }
}