package com.example.eventerplanner.ui.bottomTabs.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventerplanner.data.repository.IRepositoryImpl
import com.example.eventerplanner.domain.entity.CardCategories
import com.example.eventerplanner.domain.entity.CardCategoriesAndEvents
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.usecases.homeTab.cardCategoriesAndEvents.GetCardCategoriesAndEventsUseCase
import com.example.eventerplanner.domain.usecases.homeTab.cardCategoriesAndEvents.InsertCardCategoriesAndEventsUseCase
import com.example.eventerplanner.domain.usecases.homeTab.categories.GetCardCategoriesListUseCase
import com.example.eventerplanner.domain.usecases.homeTab.categories.InsertCardCategoriesUseCase
import com.example.eventerplanner.domain.usecases.homeTab.events.GetEventListUseCase
import com.example.eventerplanner.domain.usecases.homeTab.events.InsertEventUseCase
import com.example.eventerplanner.ui.common.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 * На уровне ViewModel будут только UseCases
 * А на уровне UseCases будут репозитории
 * */
class HomeViewModel @Inject constructor(
    private val insertCardCategories: InsertCardCategoriesUseCase,
    private val insertCardCategoriesAndEventsUseCase: InsertCardCategoriesAndEventsUseCase,
    private val getCardCategoriesAndEventsUseCase: GetCardCategoriesAndEventsUseCase,
    private val getEventListUseCase: GetEventListUseCase,
    private val getCardCategories: GetCardCategoriesListUseCase
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    private var cardCategoriesList = emptyList<CardCategories>()
    private var eventList = emptyList<Event>()
    init {
        intent {
            viewModelScope.launch { initialProcess() }
        }
    }

    private suspend fun initialProcess() {
        getCardCategories.invoke().collect { cardCategoriesList = it }
        getEventListUseCase.invoke().collect { eventList = it }

        intent {
            reduce {
                state.copy(
                    screenState = UiState.Loading,
                    categories = cardCategoriesList,
                    events = eventList,
                    sorted = HomeState.Sort.EARLIER,
                    filter = HomeState.Filter.ALL
                )
            }
        }
    }

    suspend fun insertCardCategories(cardCategories: CardCategories) {
        viewModelScope.launch {
            insertCardCategories.invoke(cardCategories)
        }
    }

    fun getCardCategoriesAndEvents(): List<CardCategoriesAndEvents> {
        var list = emptyList<CardCategoriesAndEvents>()
        viewModelScope.launch {
            getCardCategoriesAndEventsUseCase.invoke().collect {
                list = it
            }
        }
        return list
    }

    suspend fun insertCardCategoriesAndEvents(cardCategoriesAndEvents: CardCategoriesAndEvents) {
        withContext(Dispatchers.IO) {
            launch {
                insertCardCategoriesAndEventsUseCase.invoke(cardCategoriesAndEvents)
            }
        }
    }

    fun showDetails(id: Int) {
        intent {
            postSideEffect(HomeSideEffect.ShowDetailEvent(id))
        }
    }

    fun showEvent() {
        intent {
            postSideEffect(HomeSideEffect.Event)
        }
    }

    fun showCardCategories() {
        intent {
            postSideEffect(HomeSideEffect.ShowDetailCategories)
        }
    }
}