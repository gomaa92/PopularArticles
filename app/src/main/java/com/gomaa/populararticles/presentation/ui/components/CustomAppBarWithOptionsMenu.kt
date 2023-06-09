package com.gomaa.populararticles.presentation.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomAppBarWithOptionsMenu(
    title: String,
    optionsMenuIcon: ImageVector,
    menuItems: List<Int>,
    onMenuItemClick: (Int) -> Unit
) {
    val menuExpanded = remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = { menuExpanded.value = true }) {
                Icon(imageVector = optionsMenuIcon, contentDescription = "Options menu")
            }

            DropdownMenu(
                expanded = menuExpanded.value,
                onDismissRequest = { menuExpanded.value = false }
            ) {
                menuItems.forEach { period ->
                    DropdownMenuItem(onClick = {
                        menuExpanded.value = false
                        onMenuItemClick(period)
                    }) {
                        Text(text = "$period")
                    }
                }
            }
        }
    )
}
