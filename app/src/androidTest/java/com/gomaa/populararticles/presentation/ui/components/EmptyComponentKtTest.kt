package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.populararticles.presentation.ui.components.EmptyComponentConstants.empty_state_image
import com.gomaa.populararticles.presentation.ui.components.EmptyComponentConstants.subTitle
import com.gomaa.populararticles.presentation.ui.components.EmptyComponentConstants.title
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

        composeTestRule.onNodeWithContentDescription(empty_state_image).assertIsDisplayed()

        composeTestRule.onNodeWithTag(title).assertIsDisplayed()

        composeTestRule.onNodeWithTag(subTitle).assertIsDisplayed()
    }
}