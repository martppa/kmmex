package com.madapp.sample.kmm

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    val viewModelScope: CoroutineScope
    protected actual open fun onCleared()
}