package com.mercadolibre.challenge.presentation.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import com.mercadolibre.challenge.presentation.components.MELIDropDown
import com.mercadolibre.challenge.presentation.components.MELITextField
import com.mercadolibre.challenge.presentation.components.Size
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
    list: MutableList<ResponseSites>,
) {
    viewModel.onChangeValueSiteId(list[0].id)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .semantics { contentDescription = "Search Screen" }
    ) {
        MELIDropDown(
            size = Size.Large,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp),
            list = list,
            onClick = {
                viewModel.onChangeValueSiteId(it)
            }
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