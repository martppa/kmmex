package com.martppa.kmmex.core


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
