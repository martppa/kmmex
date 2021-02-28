package com.martppa.kmmex.core.presentation.controller.register

import com.martppa.kmmex.core.domain.exception.ExceptionHandler
import com.martppa.kmmex.core.presentation.controller.BaseIOScopedController

class BaseRegisterController(
    exceptionHandler: ExceptionHandler
) : BaseIOScopedController(exceptionHandler), RegisterController {

    override var username: String? = null
    override var password: String? = null

    protected open var goToHomeScreen: (() -> Unit)? = null

    override fun registerClicked() {

    }
}