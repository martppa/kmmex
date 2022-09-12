package com.madapp.sample.kmm

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.coroutines.cancellation.CancellationException

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        count()
    }

    private fun count() = viewModelScope.launch {
        while (true) {
            _state.update { it.copy(counter = it.counter + 1) }
            delay(1000)
        }
    }

    fun onNextClicked() {
        _state.update { it.copy(navigateToNext = Event(Unit)) }
    }
}