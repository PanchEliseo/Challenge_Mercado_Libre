package com.mercadolibre.challenge.presentation.searchResult.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * This composable expects [textError] that show user, [paddingValues] to padding content in screen
 */
@Composable
fun SearchError(
    textError: String = "",
    paddingValues: PaddingValues
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
    ){
        Text(text = textError)
    }
}
