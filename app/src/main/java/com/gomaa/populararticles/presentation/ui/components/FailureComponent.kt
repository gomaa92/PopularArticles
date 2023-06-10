package com.gomaa.populararticles.presentation.ui.components

import android.app.Activity
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.gomaa.populararticles.R

@Composable
fun FailureComponent(
    retry: () -> Unit
) {
    val activity = (LocalContext.current as? Activity)
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                text = stringResource(id = R.string.error_title),
                modifier = Modifier.testTag("Title")
            )
        },
        text = {
            Text(
                text = stringResource(id = R.string.error_subtitle),
                modifier = Modifier.testTag("subTitle")
            )
        },
        confirmButton = {
            TextButton(
                onClick = retry,
                modifier = Modifier.testTag("confirmButton")
            ) {
                Text(stringResource(id = R.string.retry))
            }
        },
        dismissButton = {
            TextButton(
                onClick = { activity?.finish() },
                modifier = Modifier.testTag("dismissButton")
            ) {
                Text(stringResource(id = R.string.close_app))
            }
        },
        properties = DialogProperties(dismissOnClickOutside = false)
    )
}