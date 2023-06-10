package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.populararticles.domain.entity.ArticleEntity
import org.junit.Rule
import org.junit.Test

class ArticlesComponentKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun emptyComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            ArticleItem(
                ArticleEntity(
                    title = "title",
                    publishedDate = "123",
                    byLine = "text",
                    url = "url"
                )
            )
        }

        composeTestRule.onNodeWithTag("item_title", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("item_card", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("item_date", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("item_byline", useUnmergedTree = true).assertIsDisplayed()
    }
}