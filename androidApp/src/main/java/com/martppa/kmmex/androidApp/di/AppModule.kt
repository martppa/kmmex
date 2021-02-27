package com.martppa.kmmex.androidApp.di

import com.martppa.kmmex.androidApp.exception.LogExceptionHandler
import com.martppa.kmmex.core.domain.exception.ExceptionHandler
import com.martppa.kmmex.core.domain.exception.ExceptionHandlerGroup
import com.martppa.kmmex.androidApp.exception.CrashlyticsExceptionHandler
import org.koin.dsl.module

val appModule = module {
    single<ExceptionHandler> {
        ExceptionHandlerGroup(
            listOf(
                LogExceptionHandler(),
                CrashlyticsExceptionHandler()
            )
        )
    }
}