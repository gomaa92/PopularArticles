package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.populararticles.domain.entity.ArticleEntity
import com.gomaa.populararticles.presentation.ui.components.ArticleDetailsComponentConstants.article_details_byline
import com.gomaa.populararticles.presentation.ui.components.ArticleDetailsComponentConstants.article_details_date
import com.gomaa.populararticles.presentation.ui.components.ArticleDetailsComponentConstants.article_details_title
import com.gomaa.populararticles.presentation.ui.components.ArticleDetailsComponentConstants.article_details_url
import org.junit.Rule
import org.junit.Test

class ArticleDetailsComponentKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun emptyComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            ArticleDetailsComponent(
                ArticleEntity(
                    title = "title",
                    publishedDate = "123",
                    byLine = "text",
                    url = "url"
                )
            )
        }

        composeTestRule.onNodeWithTag(article_details_title).assertIsDisplayed()
        composeTestRule.onNodeWithTag(article_details_date).assertIsDisplayed()
        composeTestRule.onNodeWithTag(article_details_byline).assertIsDisplayed()
        composeTestRule.onNodeWithTag(article_details_url).assertIsDisplayed()
    }
}