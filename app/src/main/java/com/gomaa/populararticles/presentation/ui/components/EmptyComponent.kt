package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gomaa.populararticles.R

@Composable
fun EmptyComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty),
            contentDescription = "Empty state image",
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(id = R.string.empty_state_title),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = stringResource(id = R.string.empty_state_subtitle),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        )
    }
}