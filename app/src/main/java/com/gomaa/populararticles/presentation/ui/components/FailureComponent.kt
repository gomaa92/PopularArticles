package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesViewModel

@Composable
fun FailureComponent(
    viewModel: MostPopularArticlesViewModel,
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Error occurred") },
        text = { Text(text = "An error occurred please make sure you are connected and try again ") },
        confirmButton = {
            TextButton(onClick = { viewModel.getPopularArticles(7) }) {
                Text("Retry")
            }
        },
        dismissButton = {
            TextButton(onClick = { }) {
                Text("Cancel")
            }
        },
        properties = DialogProperties(dismissOnClickOutside = false)
    )
}