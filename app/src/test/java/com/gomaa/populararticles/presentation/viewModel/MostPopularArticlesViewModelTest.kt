package com.gomaa.populararticles.presentation.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gomaa.populararticles.domain.entity.ArticleEntity
import com.gomaa.populararticles.domain.usecase.MostPopularArticlesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class MostPopularArticlesViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val testScope = TestCoroutineScope()

    private val useCase: MostPopularArticlesUseCase = mock()
    private val viewModel = MostPopularArticlesViewModel(useCase, testScope)

    @Test
    fun `getPopularArticles should emit proper state when use case returns articles`() =
        runBlockingTest {
            // Arrange
            val period = 7
            val articles = listOf<ArticleEntity>()
            val articlesResult =
                MostPopularArticlesContractor.ArticlesResult.GetArticlesSuccess(articles)
            val expectedState =
                MostPopularArticlesContractor.ArticlesViewState.GetArticlesSuccess(articles)

            doReturn(flow {
                emit(articlesResult)
            }).`when`(useCase).execute(period)

            // Act
            viewModel.getPopularArticles(period)

            // Assert
            assert(viewModel.popularArticlesStateFlow.value == expectedState)
            verify(useCase).execute(period)
        }

    @Test
    fun `getPopularArticles should emit proper state when use case returns failure`() =
        runBlockingTest {
            // Arrange
            val period = 7
            val articlesResult =
                MostPopularArticlesContractor.ArticlesResult.GetArticlesFailed
            val expectedState =
                MostPopularArticlesContractor.ArticlesViewState.GetArticlesFailed

            doReturn(flow {
                emit(articlesResult)
            }).`when`(useCase).execute(period)

            // Act
            viewModel.getPopularArticles(period)

            // Assert
            assert(viewModel.popularArticlesStateFlow.value == expectedState)
            verify(useCase).execute(period)
        }

    @Test
    fun `getPopularArticles should emit proper state when use case returns Empty`() =
        runBlockingTest {
            // Arrange
            val period = 7
            val articlesResult =
                MostPopularArticlesContractor.ArticlesResult.GetArticlesEmpty
            val expectedState =
                MostPopularArticlesContractor.ArticlesViewState.GetArticlesEmpty

            doReturn(flow {
                emit(articlesResult)
            }).`when`(useCase).execute(period)

            // Act
            viewModel.getPopularArticles(period)

            // Assert
            assert(viewModel.popularArticlesStateFlow.value == expectedState)
            verify(useCase).execute(period)
        }
}