package com.mercadolibre.challenge.presentation.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.components.MELITextField
import com.mercadolibre.challenge.presentation.search.SearchViewModel

/**
 * This composable expects [paddingValues] to padding content in view, [viewModel] that holds
 * information about search view, [valueTextField] text to search
 */
@Composable
fun SearchViewContent(
    paddingValues: PaddingValues,
    viewModel: SearchViewModel,
    valueTextField: String,
    valueSiteId: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .semantics { contentDescription = "Search Screen" }
    ) {
        MELITextField(
            value = valueSiteId,
            onValueChange = {
                viewModel.onChangeValueSiteId(it)
            },
            imageVector = Icons.Default.Search,
            placeHolder = R.string.label_site_id,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .semantics { contentDescription = "Label Site Id" }
        )
        MELITextField(
            value = valueTextField,
            onValueChange = {
                viewModel.onChangeValueChange(it)
            },
            imageVector = Icons.Default.Search,
            placeHolder = R.string.label_search,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .semantics { contentDescription = "Label Search" }
        )
    }
}