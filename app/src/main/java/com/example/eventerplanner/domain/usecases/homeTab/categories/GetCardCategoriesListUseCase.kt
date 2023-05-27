package com.example.eventerplanner.domain.usecases.homeTab.categories

import com.example.eventerplanner.data.mapper.CardCategoriesListMapper
import com.example.eventerplanner.data.mapper.IMapper
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCardCategoriesListUseCase @Inject constructor(
    private val homeRepository: IRepository.IHome,
    private val mapper: CardCategoriesListMapper
) {

    operator fun invoke(): Flow<List<CardCategories>> =
        homeRepository.getCardCategoriesList().map { cardCategories ->
            mapper.mapListDbModelToListEntity(cardCategories)
        }
}