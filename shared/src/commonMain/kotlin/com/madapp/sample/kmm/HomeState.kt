package com.madapp.sample.kmm

data class HomeState(
    val counter: Int = 0,
    val navigateToNext: Event<Unit>? = null
)