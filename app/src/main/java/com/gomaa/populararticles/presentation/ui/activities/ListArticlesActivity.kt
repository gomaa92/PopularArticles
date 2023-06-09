package com.gomaa.populararticles.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.gomaa.populararticles.R
import com.gomaa.populararticles.presentation.ui.components.CustomAppBarWithOptionsMenu
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
                            CustomAppBarWithOptionsMenu(
                                title = stringResource(id = R.string.list_article_activity_title),
                                optionsMenuIcon = ImageVector.vectorResource(id = R.drawable.ic_expand_more),
                                menuItems = listOf(1, 7, 30),
                                onMenuItemClick = { period ->
                                    viewModel.getPopularArticles(period)
                                }
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