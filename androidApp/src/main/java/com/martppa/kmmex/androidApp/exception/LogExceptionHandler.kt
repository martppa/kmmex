package com.martppa.kmmex.androidApp.exception

import android.util.Log
import com.martppa.kmmex.core.domain.exception.ExceptionHandler

class LogExceptionHandler(
    private val tag: String = "LogExceptionHandler"
) : ExceptionHandler {

    override fun handleException(exception: Throwable) {
        Log.e(tag, exception.message, exception)
    }
}
