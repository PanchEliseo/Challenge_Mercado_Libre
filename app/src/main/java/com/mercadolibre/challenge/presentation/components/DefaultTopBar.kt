package com.mercadolibre.challenge.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.mercadolibre.challenge.R

/**
 * This composable expects [title] text to show in bar, [onBack] lambda that triggers to back view,
 * [upAvailable] value to show or no the back icon.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: Int = R.string.label_search,
    onBack:() -> Unit = {},
    upAvailable: Boolean = false,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = onBack ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "TopBar")
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow)
    )
}
