package com.martppa.kmmex.androidApp.exception

import com.martppa.kmmex.core.domain.exception.ExceptionHandler

class CrashlyticsExceptionHandler(
    private val tag: String = "CrashlyticsExceptionHandler"
) : ExceptionHandler {
    override fun handleException(exception: Throwable) {
        // TODO "Implement Crashlytics error in order to track non critical exceptions"
    }
}
