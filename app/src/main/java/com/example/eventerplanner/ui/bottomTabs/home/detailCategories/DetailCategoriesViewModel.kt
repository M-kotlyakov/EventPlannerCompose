package com.example.eventerplanner.ui.bottomTabs.home.detailCategories

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class DetailCategoriesViewModel @Inject constructor():
    ContainerHost<DetailCategoriesState, DetailCategoriesSideEffect>,
    ViewModel() {

    override val container = container<DetailCategoriesState, DetailCategoriesSideEffect>(
        DetailCategoriesState()
    )
}