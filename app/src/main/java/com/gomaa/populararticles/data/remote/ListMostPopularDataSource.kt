package com.gomaa.populararticles.data.remote

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.base.data.remote.NetworkServiceCall
import com.gomaa.populararticles.data.model.ArticlesResponse

interface ListMostPopularDataSource : NetworkServiceCall {
   suspend fun getMostPopularArticles(period: Int): NetworkResponse<ArticlesResponse>
}
