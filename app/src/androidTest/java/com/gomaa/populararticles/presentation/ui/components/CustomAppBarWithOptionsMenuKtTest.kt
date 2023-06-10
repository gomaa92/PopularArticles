package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.gomaa.populararticles.R
import com.gomaa.populararticles.presentation.ui.components.CustomAppBarWithOptionsMenuConstants.DropdownMenu
import com.gomaa.populararticles.presentation.ui.components.CustomAppBarWithOptionsMenuConstants.IconButton
import com.gomaa.populararticles.presentation.ui.components.CustomAppBarWithOptionsMenuConstants.appBarTitle
import org.junit.Rule
import org.junit.Test

class CustomAppBarWithOptionsMenuKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appBarComponent_displaysExpectedElements() {
        // Set up the test content
        composeTestRule.setContent {
            CustomAppBarWithOptionsMenu(
                "title",
                ImageVector.vectorResource(id = R.drawable.ic_expand_more),
                listOf()
            ) { }
        }

        composeTestRule.onNodeWithTag(appBarTitle).assertIsDisplayed()
        composeTestRule.onNodeWithTag(IconButton).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DropdownMenu).assertDoesNotExist()
    }
}