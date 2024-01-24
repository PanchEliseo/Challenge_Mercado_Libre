package com.mercadolibre.challenge.presentation.searchResult

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.presentation.searchResult.components.ProgressBar
import com.mercadolibre.challenge.presentation.searchResult.components.SearchError
import com.mercadolibre.challenge.presentation.searchResult.components.SearchResultContent

@Composable
fun SearchResult(
    paddingValues: PaddingValues,
    navController: NavHostController,
    product: String,
    viewModel: SearchResultViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.searchProducts(product)
    }
    val response = viewModel.searchResultViewState.collectAsState(initial = UIState.Loading)
    when (val searchResponse = response.value) {
        UIState.Loading -> {
            ProgressBar()
        }
        is UIState.Success -> {
            searchResponse.result.results?.let { list ->
                SearchResultContent(
                    paddingValues = paddingValues,
                    navController = navController,
                    listResult = list,
                )
            }
        }
        is UIState.Failure -> {
            SearchError(searchResponse.message)
        }
    }
}