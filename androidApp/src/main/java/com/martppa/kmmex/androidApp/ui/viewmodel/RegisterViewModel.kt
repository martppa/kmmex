package com.martppa.kmmex.androidApp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.martppa.kmmex.core.presentation.controller.register.RegisterController

class RegisterViewModel(
    private val registerController: RegisterController
) : BaseViewModel(registerController), RegisterController {

    private val mutableLiveUsername = MutableLiveData<String>()
    val liveUsername: LiveData<String> = mutableLiveUsername

    private val mutableLivePassword = MutableLiveData<String>()
    val livePassword: LiveData<String> = mutableLivePassword

    override var username: String? = registerController.username
        set(value) {
            field = value
            mutableLiveUsername.value = value
        }

    override var password: String? = registerController.password
        set(value) {
            field = value
            mutableLivePassword.value = value
        }

    override fun registerClicked() {
        registerController.registerClicked()
    }
}