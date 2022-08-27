package com.madapp.sample.kmm

class Event<out T>(
    private val value: T
) {
    private var canConsume = true
    fun takeValue() = value

    fun consume(block: (T) -> Unit) {
        if (this.canConsume) {
            canConsume = false
            block(value)
        }
    }
}