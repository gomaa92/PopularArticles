package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.gomaa.populararticles.presentation.ui.components.LoadingComponentConstants.loadingBox
import com.gomaa.populararticles.presentation.ui.components.LoadingComponentConstants.loadingIndicator

@Composable
fun LoadingComponent(showLoading: Boolean) {

    if (showLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .testTag(loadingBox),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.testTag(loadingIndicator))
        }
    }
}

object LoadingComponentConstants {
    const val loadingBox = "loadingBox"
    const val loadingIndicator = "loadingIndicator"
}