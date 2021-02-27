package com.martppa.kmmex.core.domain.exception

interface ExceptionHandler {
    fun handleException(exception: Throwable)
}
