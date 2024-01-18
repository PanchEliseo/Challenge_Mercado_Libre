package com.mercadolibre.challenge.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mercadolibre.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView() {
    Column {
        Text(text = stringResource(id = R.string.search_label))
        OutlinedTextField(value = "", onValueChange = {})
    }
}