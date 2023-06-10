package com.gomaa.populararticles.domain.usecase

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.populararticles.data.model.Article
import com.gomaa.populararticles.data.model.ArticlesResponse
import com.gomaa.populararticles.domain.mapper.ArticlesDomainMapper
import com.gomaa.populararticles.domain.repository.ListMostPopularRepository
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MostPopularArticlesUseCaseTest {

    @Mock
    private lateinit var repository: ListMostPopularRepository

    private lateinit var mostPopularArticlesUseCase: MostPopularArticlesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mostPopularArticlesUseCase = MostPopularArticlesUseCase(repository)
    }

    @Test
    fun `test get most popular articles success`() = runBlocking {
        // Arrange
        val input = 7
        val dataArticles = listOf(
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            ),
            Article(
                id = 1,
                media = null,
                publishedDate = "date",
                section = null,
                source = null,
                subsection = null,
                title = "title",
                type = null,
                updated = null,
                uri = null,
                url = "url",
                byline = "byline"
            )
        )
        val response = NetworkResponse.Success(ArticlesResponse("text", 1, dataArticles, "text"))
        Mockito.`when`(repository.getMostPopularArticles(input)).thenReturn(response)

        // Map data layer articles to domain layer articles
        val domainArticles = ArticlesDomainMapper.mapDataArticlesToDomainArticles(dataArticles)

        // Act
        val result = mostPopularArticlesUseCase.execute(input).toList()

        // Assert
        assertEquals(1, result.size)
        assert(result[0] is MostPopularArticlesContractor.ArticlesResult.GetArticlesSuccess)
        assertEquals(
            domainArticles,
            (result[0] as MostPopularArticlesContractor.ArticlesResult.GetArticlesSuccess).articles
        )
    }

    @Test
    fun `test get most popular articles failure`() = runBlocking {
        // Arrange
        val input = 7
        val exception = Exception("Error")
        val response = NetworkResponse.Failure<ArticlesResponse>(exception)
        Mockito.`when`(repository.getMostPopularArticles(input)).thenReturn(response)

        // Act
        val result = mostPopularArticlesUseCase.execute(input).toList()

        // Assert
        assertEquals(1, result.size)
        assert(result[0] is MostPopularArticlesContractor.ArticlesResult.GetArticlesFailed)
    }

    @Test
    fun `test get most popular articles empty`() = runBlocking {
        // Arrange
        val input = 7
        val response = NetworkResponse.Success(ArticlesResponse("", 1, listOf(), ""))
        Mockito.`when`(repository.getMostPopularArticles(input)).thenReturn(response)

        // Act
        val result = mostPopularArticlesUseCase.execute(input).toList()

        // Assert
        assertEquals(1, result.size)
        assert(result[0] is MostPopularArticlesContractor.ArticlesResult.GetArticlesEmpty)
    }
}