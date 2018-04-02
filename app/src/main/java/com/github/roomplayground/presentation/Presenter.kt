package com.github.roomplayground.presentation


interface Presenter<in T> {
    fun attachTo(view: T)
}