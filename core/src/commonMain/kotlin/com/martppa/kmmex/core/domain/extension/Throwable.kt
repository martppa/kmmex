package com.martppa.kmmex.core.domain.extension

import com.martppa.kmmex.core.domain.exception.ErrorCode

fun Throwable?.getMessage() = this?.message ?: ErrorCode.UNKNOWN