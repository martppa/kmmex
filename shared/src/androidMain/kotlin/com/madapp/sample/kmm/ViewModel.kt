package com.madapp.sample.kmm

import androidx.lifecycle.ViewModel as AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope as superViewModelScope

actual abstract class ViewModel : AndroidViewModel() {
    actual val viewModelScope: CoroutineScope = superViewModelScope
    actual override fun onCleared() {}
}