package com.martppa.kmmex.core.domain.exception

import com.martppa.kmmex.core.domain.model.RequestError


class RequestException(
        val requestError: RequestError
) : Exception(requestError.reason)