package com.gomaa.populararticles.presentation.ui.components

import android.app.Activity
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.gomaa.populararticles.R
import com.gomaa.populararticles.presentation.viewModel.MostPopularArticlesViewModel

@Composable
fun FailureComponent(
    viewModel: MostPopularArticlesViewModel,
) {
    val activity = (LocalContext.current as? Activity)
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(id = R.string.error_title)) },
        text = { Text(text = stringResource(id = R.string.error_subtitle)) },
        confirmButton = {
            TextButton(onClick = { viewModel.getPopularArticles(7) }) {
                Text(stringResource(id = R.string.retry))
            }
        },
        dismissButton = {
            TextButton(onClick = { activity?.finish() }) {
                Text(stringResource(id = R.string.close_app))
            }
        },
        properties = DialogProperties(dismissOnClickOutside = false)
    )
}