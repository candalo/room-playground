package com.github.roomplayground.domain


interface UseCase<in T, out S> {
    fun execute(params: T, listener: UseCaseResult<S>)
}