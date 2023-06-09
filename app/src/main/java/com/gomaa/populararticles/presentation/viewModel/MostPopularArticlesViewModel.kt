package com.gomaa.populararticles.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gomaa.populararticles.domain.usecase.MostPopularArticlesUseCase
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor.ArticlesResult
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor.ArticlesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MostPopularArticlesViewModel @Inject constructor(private val useCase: MostPopularArticlesUseCase) :
    ViewModel() {

    private val _popularArticlesStateFlow =
        MutableStateFlow<ArticlesViewState>(ArticlesViewState.Loading())
    val popularArticlesStateFlow: StateFlow<ArticlesViewState> = _popularArticlesStateFlow

    fun getPopularArticles(period: Int) {
        viewModelScope.launch {
            useCase.execute(period)
                .onStart {
                    _popularArticlesStateFlow.value = ArticlesViewState.Loading()
                }
                .catch {
                    _popularArticlesStateFlow.value = ArticlesViewState.GetArticlesFailed
                }
                .collect { result ->
                    val state = when (result) {
                        ArticlesResult.GetArticlesEmpty -> {
                            ArticlesViewState.GetArticlesEmpty
                        }
                        ArticlesResult.GetArticlesFailed -> {
                            ArticlesViewState.GetArticlesFailed
                        }
                        is ArticlesResult.GetArticlesSuccess -> {
                            ArticlesViewState.GetArticlesSuccess(result.articles)
                        }
                    }
                    _popularArticlesStateFlow.value = state
                }
        }
    }
}
