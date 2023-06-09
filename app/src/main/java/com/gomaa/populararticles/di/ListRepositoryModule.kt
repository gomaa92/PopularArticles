package com.gomaa.populararticles.di

import com.gomaa.populararticles.data.remote.ListMostPopularDataSource
import com.gomaa.populararticles.data.remote.ListMostPopularDataSourceImpl
import com.gomaa.populararticles.data.repository.ListMostPopularRepositoryImpl
import com.gomaa.populararticles.domain.repository.ListMostPopularRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ListRepositoryModule {

    @Binds
    abstract fun bindRemoteDataSourceModel(
        remoteDataSource: ListMostPopularDataSourceImpl
    ): ListMostPopularDataSource

    @Binds
    abstract fun bindRepository(
        repository: ListMostPopularRepositoryImpl
    ): ListMostPopularRepository
}