package com.gomaa.populararticles.presentation.ui.activities

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gomaa.populararticles.domain.entity.ArticleEntity
import com.gomaa.populararticles.presentation.ui.activities.ArticleDetailsActivity.Companion.IconButton_bak
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticleDetailsActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ArticleDetailsActivity>()

    private lateinit var article: ArticleEntity

    @Before
    fun setUp() {
        // Initialize a sample ArticleEntity to pass as an extra
        article = ArticleEntity(
            publishedDate = "date",
            title = "Sample Article",
            byLine = "This is a sample article for testing.",
            url = "https://example.com/"
        )

        // Launch the activity with the sample ArticleEntity as an extra
        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.intent.putExtra(ArticleDetailsActivity.ARTICLE_DETAILS, article)
        }
    }

    @Test
    fun articleDetailsActivity_displaysArticleDetails() {

        // Check if the back button is displayed
        composeTestRule.onNodeWithContentDescription(IconButton_bak).assertExists()
    }
}