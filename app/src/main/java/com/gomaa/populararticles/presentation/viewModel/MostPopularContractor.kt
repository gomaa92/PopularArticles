package com.gomaa.populararticles.presentation.viewModel

import com.gomaa.populararticles.data.model.Article

interface MostPopularArticlesContractor {

    sealed class ArticlesResult {
        data class GetArticlesSuccess(val articles: List<Article>) : ArticlesResult()
        object GetArticlesFailed : ArticlesResult()
        object GetArticlesEmpty : ArticlesResult()
    }

    sealed class ArticlesViewState {
        data class GetArticlesSuccess(val articles: List<Article>) : ArticlesViewState()
        object GetArticlesFailed : ArticlesViewState()
        object GetArticlesEmpty : ArticlesViewState()
        data class Loading(val showLoading: Boolean = true) : ArticlesViewState()
    }
}
