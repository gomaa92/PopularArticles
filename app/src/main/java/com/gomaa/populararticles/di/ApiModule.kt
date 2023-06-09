package com.gomaa.populararticles.di

import com.gomaa.populararticles.data.remote.ListMostPopularService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class ApiModule {
    @Provides
    fun provideMostPopularApi(retrofit: Retrofit): ListMostPopularService {
        return retrofit.create(ListMostPopularService::class.java)
    }
}
