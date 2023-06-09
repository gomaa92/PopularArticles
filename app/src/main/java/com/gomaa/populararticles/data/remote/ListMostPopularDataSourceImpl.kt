package com.gomaa.populararticles.data.remote

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.populararticles.data.model.ArticlesResponse
import javax.inject.Inject

class ListMostPopularDataSourceImpl @Inject constructor(private val service: ListMostPopularService) :
    ListMostPopularDataSource {
    override suspend fun getMostPopularArticles(period: Int): NetworkResponse<ArticlesResponse> {

        return safeApiCall { service.getMostPopularArticles(period) }
    }
}
