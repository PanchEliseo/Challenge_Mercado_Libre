package com.mercadolibre.challenge.presentation.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.search.SearchViewModel

/**
 * This composable expects [paddingValues] to padding content in view, [viewModel] that holds
 * information about search view, [valueTextField] text to search
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewContent(
    paddingValues: PaddingValues,
    viewModel: SearchViewModel,
    valueTextField: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .semantics { contentDescription = "Search Screen" }
    ) {
        OutlinedTextField(
            value = valueTextField,
            onValueChange = {
                viewModel.onChangeValueChange(it)
            },
            maxLines = 1,
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Icon search")
            },
            label = {
                Text(text = stringResource(id = R.string.label_search))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .semantics { contentDescription = "Label Search" }
        )
    }
}