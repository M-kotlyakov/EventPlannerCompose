package com.example.eventerplanner.domain.usecases.homeTab.categories

import com.example.eventerplanner.data.mapper.CardCategoriesListMapper
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.repository.IRepository
import javax.inject.Inject

class InsertCardCategoriesUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: CardCategoriesListMapper
) {

    suspend operator fun invoke(cardCategories: CardCategories) {
        homeRepository.insertCategories(mapper.mapEntityToDbModel(cardCategories))
    }
}