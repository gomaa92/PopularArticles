package com.gomaa.populararticles.data.remote

import com.gomaa.populararticles.data.model.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ListMostPopularService {
    @GET("svc/mostpopular/v2/viewed/{period}.json")
    suspend fun getMostPopularArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String = "QlYGyjXK7GDLlarIFTAHXSjAocG0nmML"
    ): ArticlesResponse
}
