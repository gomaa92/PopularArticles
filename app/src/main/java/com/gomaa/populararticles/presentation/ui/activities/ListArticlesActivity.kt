package com.gomaa.populararticles.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.gomaa.populararticles.presentation.ui.screens.MostPopularArticlesScreen
import com.gomaa.populararticles.presentation.ui.theme.PopularArticlesTheme
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListArticlesActivity : ComponentActivity() {
    private val viewModel: MostPopularArticlesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopularArticlesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Most Popular Articles") },
                                backgroundColor = MaterialTheme.colors.primary
                            )
                        },
                        content = {
                            MostPopularArticlesScreen(viewModel)
                        }
                    )
                }
            }
        }
    }
}