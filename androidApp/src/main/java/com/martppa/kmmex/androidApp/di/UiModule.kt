package com.martppa.kmmex.androidApp.di

import com.martppa.kmmex.androidApp.ui.viewmodel.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { RegisterViewModel(get()) }
}