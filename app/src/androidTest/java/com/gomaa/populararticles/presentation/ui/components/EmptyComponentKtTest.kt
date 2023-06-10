package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class EmptyComponentKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun emptyComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            EmptyComponent()
        }

        composeTestRule.onNodeWithContentDescription("Empty state image").assertIsDisplayed()

        composeTestRule.onNodeWithTag("TITLE").assertIsDisplayed()

        composeTestRule.onNodeWithTag("subTitle").assertIsDisplayed()
    }
}