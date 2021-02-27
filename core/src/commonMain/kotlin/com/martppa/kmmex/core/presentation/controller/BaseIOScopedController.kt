package com.martppa.kmmex.core.presentation.controller

import com.martppa.kmmex.core.domain.exception.ExceptionHandler
import kotlinx.coroutines.*

open class BaseIOScopedController(
    exceptionHandler: ExceptionHandler
): BaseController(exceptionHandler), IOScopedController {

    override fun <R> launch(pre: (() -> Unit)?, handler: suspend () -> R, post: ((R) -> Unit)?) {
        launch(Dispatchers.Main) {
            pre?.invoke()
            val result = withContext(Dispatchers.Default) { handler() }
            post?.invoke(result)
        }
    }
}