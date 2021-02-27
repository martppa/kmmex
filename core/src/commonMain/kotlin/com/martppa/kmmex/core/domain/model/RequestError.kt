package com.martppa.kmmex.core.domain.model

data class RequestError(
    val code: String,
    val message: String,
    val errors: List<RequestError>?
) {
    val reason: String get() = if (errors != null && errors.isNotEmpty()) errors[0].reason else code
}