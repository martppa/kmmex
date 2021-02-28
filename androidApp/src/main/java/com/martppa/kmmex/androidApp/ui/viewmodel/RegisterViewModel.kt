package com.martppa.kmmex.androidApp.ui.viewmodel

import com.martppa.kmmex.core.presentation.controller.register.RegisterController

class RegisterViewModel(
    private val registerController: RegisterController
) : BaseViewModel(registerController), RegisterController {

    override fun registerClicked() {
        registerController.registerClicked()
    }
}