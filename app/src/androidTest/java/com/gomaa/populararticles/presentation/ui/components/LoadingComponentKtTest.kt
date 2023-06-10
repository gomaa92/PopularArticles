package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class LoadingComponentKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loadingComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            LoadingComponent(true)
        }

        composeTestRule.onNodeWithTag("loadingBox").assertIsDisplayed()

        composeTestRule.onNodeWithTag("loadingIndicator").assertIsDisplayed()
    }

    @Test
    fun loadingComponent_displaysExpectedElementsFalse() {
        // Set up the test content
        composeTestRule.setContent {
            LoadingComponent(false)
        }

        composeTestRule.onNodeWithTag("loadingBox").assertDoesNotExist()

        composeTestRule.onNodeWithTag("loadingIndicator").assertDoesNotExist()
    }
}