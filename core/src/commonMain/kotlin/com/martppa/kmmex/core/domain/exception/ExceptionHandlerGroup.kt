package com.martppa.kmmex.core.domain.exception

class ExceptionHandlerGroup(
    private val exceptionHandlers: List<ExceptionHandler>
) : ExceptionHandler {
    override fun handleException(exception: Throwable) =
        exceptionHandlers.forEach { it.handleException(exception) }
}