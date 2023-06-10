package com.gomaa.populararticles.data.repository

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.populararticles.data.model.Article
import com.gomaa.populararticles.data.model.ArticlesResponse
import com.gomaa.populararticles.data.model.Media
import com.gomaa.populararticles.data.model.MediaMetadata
import com.gomaa.populararticles.data.remote.ListMostPopularDataSource
import com.gomaa.populararticles.domain.repository.ListMostPopularRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


internal class ListMostPopularRepositoryImplTest {
    private lateinit var repositroy: ListMostPopularRepository

    @Mock
    lateinit var remoteDataSource: ListMostPopularDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repositroy = ListMostPopularRepositoryImpl(remoteDataSource)
    }

    @Test
    fun getArticlesListReturnFailed() {
        runBlocking {

            val networkResponse = NetworkResponse.Failure<ArticlesResponse>(Exception())

            Mockito.`when`(remoteDataSource.getMostPopularArticles(7)).thenReturn(networkResponse)

            Assert.assertEquals(networkResponse, repositroy.getMostPopularArticles(7))
        }
    }

    @Test
    fun getArticleListReturnSuccess() {
        runBlocking {
            val response = ArticlesResponse(
                copyright = "some text",
                numResults = 1,
                articles = listOf(
                    Article(
                        id = 1,
                        publishedDate = "text",
                        section = "text",
                        subsection = "text",
                        source = "text",
                        title = "title",
                        type = "text",
                        updated = "text",
                        url = "text",
                        uri = "text",
                        byline = "text",
                        media = listOf(
                            Media(
                                caption = "text",
                                copyright = "text",
                                subtype = "text",
                                type = "text",
                                mediaMetadata = listOf(
                                    MediaMetadata(
                                        format = "text",
                                        height = 1,
                                        width = 1,
                                        url = "text"
                                    )
                                )
                            )
                        )
                    )
                ),
                status = "some text"
            )


            val networkResponse = NetworkResponse.Success<ArticlesResponse>(response)

            Mockito.`when`(remoteDataSource.getMostPopularArticles(1)).thenReturn(networkResponse)

            Assert.assertEquals(networkResponse, repositroy.getMostPopularArticles(1))
        }
    }
}