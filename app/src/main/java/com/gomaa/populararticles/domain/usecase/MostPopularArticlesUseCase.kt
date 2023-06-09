package com.gomaa.populararticles.domain.usecase

import com.gomaa.base.data.remote.NetworkResponse
import com.gomaa.base.domain.usecase.SuspendableUseCase
import com.gomaa.populararticles.domain.repository.ListMostPopularRepository
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor.ArticlesResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MostPopularArticlesUseCase @Inject constructor(private val repository: ListMostPopularRepository) :
    SuspendableUseCase<Int, ArticlesResult> {
    override suspend fun execute(input: Int): Flow<ArticlesResult> = flow {
        when (val result = repository.getMostPopularArticles(input)) {
            is NetworkResponse.Failure -> {
                emit(ArticlesResult.GetArticlesFailed)
            }
            is NetworkResponse.Success -> {
                if (result.data.articles.isEmpty()) {
                    emit(ArticlesResult.GetArticlesEmpty)
                } else {
                    emit(ArticlesResult.GetArticlesSuccess(result.data.articles))
                }
            }
        }
    }
}
