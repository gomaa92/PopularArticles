package com.gomaa.populararticles.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.gomaa.populararticles.domain.usecase.MostPopularArticlesUseCase
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor.ArticlesResult
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor.ArticlesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MostPopularArticlesViewModel @Inject constructor(private val useCase: MostPopularArticlesUseCase) :
    ViewModel() {

    constructor(
        useCase: MostPopularArticlesUseCase,
        viewModelScope: CoroutineScope
    ) : this(useCase) {
        this.viewModelScope = viewModelScope
    }

    private var viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    var period = 7

    private val _popularArticlesStateFlow =
        MutableStateFlow<ArticlesViewState>(ArticlesViewState.Loading())
    val popularArticlesStateFlow: StateFlow<ArticlesViewState> = _popularArticlesStateFlow

    fun getPopularArticles() {
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
