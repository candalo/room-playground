package com.github.roomplayground.domain


interface UseCaseResult<in T> {
    fun getUseCaseResult(result: T)
}