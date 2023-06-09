package com.gomaa.base.domain.usecase

interface UseCase<I, O> {
    fun execute(input: I? = null): O
}
