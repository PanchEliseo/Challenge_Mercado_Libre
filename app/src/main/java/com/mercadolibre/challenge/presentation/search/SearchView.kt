package com.mercadolibre.challenge.presentation.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.components.DefaultTopBar
import com.mercadolibre.challenge.presentation.search.components.ButtonSearch
import com.mercadolibre.challenge.presentation.search.components.SearchViewContent

/**
 * This composable expects [onBack] lambda that triggers to back view, [onSearch] lambda that
 * triggers to send product to search and next view, [viewModel] that holds information about search
 * view
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    onBack:() -> Unit = {},
    onSearch:(product: String) -> Unit = {},
    viewModel: SearchViewModel = hiltViewModel()
) {
    val valueTextField = viewModel.textValueChange.collectAsState("")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = R.string.search_label,
                onBack = onBack,
                upAvailable = false
            )
        },
        content = {
            SearchViewContent(
                paddingValues = it,
                viewModel = viewModel,
                valueTextField = valueTextField.value
            )
        },
        bottomBar = {
            ButtonSearch(
                valueTextField = valueTextField.value,
                onSearch = onSearch,
            )
        }
    )
}