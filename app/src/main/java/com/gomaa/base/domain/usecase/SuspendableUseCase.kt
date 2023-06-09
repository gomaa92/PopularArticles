package com.gomaa.base.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SuspendableUseCase<I, R> {
   suspend fun execute(input: I): Flow<R>
}
