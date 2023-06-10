package com.gomaa.populararticles.presentation.ui.components

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class FailureComponentKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Test
    fun failureComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            FailureComponent {}
        }

        composeTestRule.onNodeWithTag("Title").assertIsDisplayed()
        composeTestRule.onNodeWithTag("subTitle").assertIsDisplayed()
        composeTestRule.onNodeWithTag("confirmButton").assertIsDisplayed()
        composeTestRule.onNodeWithTag("dismissButton").assertIsDisplayed()
    }
}