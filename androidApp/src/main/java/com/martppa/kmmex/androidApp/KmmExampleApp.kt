package com.martppa.kmmex.androidApp

import android.app.Application
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

            ))
        }
    }
}