package com.martppa.kmmex.androidApp

import android.app.Application
import com.martppa.kmmex.androidApp.di.appModule
import com.martppa.kmmex.androidApp.di.uiModule
import com.martppa.kmmex.core.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmmExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        initializeDependencies()
    }

    private fun initializeDependencies() {
        startKoin {
            androidContext(this@KmmExampleApp)
            modules(listOf(
                appModule,
                uiModule,
                presentationModule
            ))
        }
    }
}