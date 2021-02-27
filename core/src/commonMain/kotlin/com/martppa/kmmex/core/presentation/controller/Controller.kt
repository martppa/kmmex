package com.martppa.kmmex.core.presentation.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface Controller {

    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job

    fun runOnError(onError: (Throwable) -> Unit): Controller
    fun runWithScope(coroutineScope: CoroutineScope): Controller
}