package com.martppa.kmmex.core.presentation.controller

interface IOScopedController : Controller {
    fun <R> launch(pre: (() -> Unit)? = null, handler: suspend () -> R, post: ((R) -> Unit)? = null)
}