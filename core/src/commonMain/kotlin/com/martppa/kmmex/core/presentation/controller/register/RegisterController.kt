package com.martppa.kmmex.core.presentation.controller.register

import com.martppa.kmmex.core.presentation.controller.IOScopedController

interface RegisterController : IOScopedController {
    var username: String?
    var password: String?
    fun registerClicked()
}