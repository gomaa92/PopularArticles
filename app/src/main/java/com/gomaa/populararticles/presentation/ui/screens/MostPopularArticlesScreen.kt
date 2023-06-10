package com.gomaa.populararticles.presentation.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.gomaa.populararticles.presentation.ui.components.ArticlesComponent
import com.gomaa.populararticles.presentation.ui.components.EmptyComponent
import com.gomaa.populararticles.presentation.ui.components.FailureComponent
import com.gomaa.populararticles.presentation.ui.components.LoadingComponent
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesContractor
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesViewModel

@Composable
fun MostPopularArticlesScreen(viewModel: MostPopularArticlesViewModel) {

    LaunchedEffect(Unit) {
        viewModel.getPopularArticles(7)
    }

    val articlesViewState by viewModel.popularArticlesStateFlow.collectAsState()

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        when (articlesViewState) {
            MostPopularArticlesContractor.ArticlesViewState.GetArticlesEmpty -> {
                EmptyComponent()
            }
            MostPopularArticlesContractor.ArticlesViewState.GetArticlesFailed -> {
                FailureComponent { viewModel.getPopularArticles(7) }
            }
            is MostPopularArticlesContractor.ArticlesViewState.GetArticlesSuccess -> {
                ArticlesComponent((articlesViewState as MostPopularArticlesContractor.ArticlesViewState.GetArticlesSuccess).articles)
            }
            is MostPopularArticlesContractor.ArticlesViewState.Loading -> {
                LoadingComponent((articlesViewState as MostPopularArticlesContractor.ArticlesViewState.Loading).showLoading)
            }
        }
    }
}
