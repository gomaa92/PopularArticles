package com.gomaa.populararticles.data.repository

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.populararticles.data.model.ArticlesResponse
import com.gomaa.populararticles.data.remote.ListMostPopularDataSource
import com.gomaa.populararticles.domain.repository.ListMostPopularRepository
import javax.inject.Inject

class ListMostPopularRepositoryImpl @Inject constructor(
    private val remoteDataSource: ListMostPopularDataSource,
) : ListMostPopularRepository {
    override suspend fun getMostPopularArticles(period: Int): NetworkResponse<ArticlesResponse> {
        return remoteDataSource.getMostPopularArticles(period)
    }

}