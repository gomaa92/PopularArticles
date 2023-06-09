package com.gomaa.populararticles.domain.repository

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.populararticles.data.model.ArticlesResponse

interface ListMostPopularRepository {
    suspend fun getMostPopularArticles(period: Int): NetworkResponse<ArticlesResponse>

}