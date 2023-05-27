package com.example.eventerplanner.ui.bottomTabs.home.detailEvent

import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventerplanner.domain.entity.Event
import com.example.eventerplanner.domain.usecases.homeTab.events.InsertEventUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class DetailEventViewModel @Inject constructor(
    private val insertEventCaseCase: InsertEventUseCase
):
    ContainerHost<DetailEventState, DetailEventSideEffect>,
    ViewModel() {

    override val container = container<DetailEventState, DetailEventSideEffect>(
        DetailEventState()
    )

    private val scope = viewModelScope

    internal fun insertEvent(event: Event) {
        scope.launch {
            insertEventCaseCase.invoke(event)
        }
//        intent {
//            scope.launch {
//                insertEventCaseCase.invoke(event)
//            }
//        }
    }
}