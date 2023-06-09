package com.gomaa.base.domain.usecase

interface SuspendableUseCase<I, O> {
    fun execute(input: I): O
}
