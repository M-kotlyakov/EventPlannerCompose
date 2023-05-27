package com.example.eventerplanner.domain.usecases.homeTab.categories

import com.example.eventerplanner.domain.repository.IRepository
import javax.inject.Inject

class RemoveCardCategories @Inject constructor(
    private val homeRepository: IRepository.IHome
) {

    suspend operator fun invoke(id: Int) {
        homeRepository.removeCardCategories(id)
    }
}