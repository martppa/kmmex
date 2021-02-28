package com.martppa.kmmex.core.presentation.di

import com.martppa.kmmex.core.presentation.controller.register.BaseRegisterController
import com.martppa.kmmex.core.presentation.controller.register.RegisterController
import org.koin.dsl.module

val presentationModule = module {
    single<RegisterController> { BaseRegisterController(get()) }
}