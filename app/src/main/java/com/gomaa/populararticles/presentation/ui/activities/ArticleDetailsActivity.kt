package com.gomaa.populararticles.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import com.gomaa.populararticles.domain.entity.ArticleEntity
import com.gomaa.populararticles.presentation.ui.components.ArticleDetailsComponent
import com.gomaa.populararticles.presentation.ui.theme.PopularArticlesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsActivity : ComponentActivity() {
    companion object {
        const val ARTICLE_DETAILS = "extra_article"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopularArticlesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val article = intent.getParcelableExtra<ArticleEntity>(ARTICLE_DETAILS)

                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("Article Details") },
                                navigationIcon =
                                {
                                    IconButton(onClick = { finish() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = "Back"
                                        )
                                    }
                                },
                                backgroundColor = MaterialTheme.colors.primary
                            )
                        },
                        content = {
                            article?.let {
                                ArticleDetailsComponent(article)
                            }
                        }
                    )
                }
            }
        }
    }
}