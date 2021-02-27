package com.martppa.kmmex.androidApp.ui.viewmodel

import androidx.lifecycle.*
import com.martppa.kmmex.androidApp.ui.lifecycle.Event
import com.martppa.kmmex.core.domain.extension.empty
import com.martppa.kmmex.core.presentation.controller.Controller
import com.martppa.kmmex.core.presentation.controller.IOScopedController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
    protected val controller: IOScopedController
) : ViewModel(), IOScopedController {

    init {
        controller.runWithScope(viewModelScope).runOnError { onError(it) }
    }

    private val mutableOnErrorEvent: MutableLiveData<Event<Throwable>> = MutableLiveData()
    val onErrorEvent: LiveData<Event<Throwable>> = mutableOnErrorEvent

    private val mutableShowLoginLoadingEvent: MutableLiveData<Event<String>> = MutableLiveData()
    val showLoginLoadingEvent: LiveData<Event<String>> = mutableShowLoginLoadingEvent

    private val mutableHideLoginLoadingEvent: MutableLiveData<Event<Unit>> = MutableLiveData()
    val hideLoginLoadingEvent: LiveData<Event<Unit>> = mutableHideLoginLoadingEvent

    protected val mediatorGoBackEvent = MediatorLiveData<Event<Unit>>()
    val goBackEvent: LiveData<Event<Unit>> = mediatorGoBackEvent

    override fun launch(context: CoroutineContext,
                        start: CoroutineStart,
                        block: suspend CoroutineScope.() -> Unit
    ): Job = controller.launch { block() }

    override fun <R> launch(pre: (() -> Unit)?, handler: suspend () -> R, post: ((R) -> Unit)?) {
        controller.launch(pre, handler, post)
    }

    open fun onCreate() {
        // Empty
    }

    open fun onDestroy() {
        // Empty
    }

    protected open fun onError(exception: Throwable) {
        hideLoading()
        mutableOnErrorEvent.value = Event(exception)
    }

    protected fun showLoading(code: String = String.empty()) {
        mutableShowLoginLoadingEvent.value = Event(code)
    }

    protected fun hideLoading() {
        mutableHideLoginLoadingEvent.value = Event(Unit)
    }

    override fun runOnError(onError: (Throwable) -> Unit): Controller {
        return controller.runOnError(onError)
    }

    override fun runWithScope(coroutineScope: CoroutineScope): Controller {
        return controller.runWithScope(coroutineScope)
    }

    open fun goBack() {
        mediatorGoBackEvent.value = Event(Unit)
    }
}
