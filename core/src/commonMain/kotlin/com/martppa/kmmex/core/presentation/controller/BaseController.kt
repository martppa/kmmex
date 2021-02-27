package com.martppa.kmmex.core.presentation.controller

import com.martppa.kmmex.core.domain.exception.ExceptionHandler
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseController(
    private val exceptionHandler: ExceptionHandler
): Controller {

    protected var onErrors = mutableListOf<(Throwable) -> Unit>()
    protected lateinit var coroutineScope: CoroutineScope

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        handleError(exception)
    }

    override fun launch(
        context: CoroutineContext,
        start: CoroutineStart,
        block: suspend CoroutineScope.() -> Unit
    ): Job = coroutineScope.launch(context + coroutineExceptionHandler, start, block)

    override fun runOnError(onError: (Throwable) -> Unit): Controller {
        this.addOnError(onError)
        return this
    }

    override fun runWithScope(coroutineScope: CoroutineScope): Controller {
        this.coroutineScope = coroutineScope
        return this
    }

    protected open fun handleError(exception: Throwable) {
        exceptionHandler.handleException(exception)
        onErrors.forEach { it.invoke(exception) }
    }

    fun addOnError(onError: (Throwable) -> Unit) {
        onErrors.add(onError)
    }
}