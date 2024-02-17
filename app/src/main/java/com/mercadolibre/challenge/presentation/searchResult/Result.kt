package com.mercadolibre.challenge.presentation.searchResult

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.model.SearchModel
import com.mercadolibre.challenge.presentation.searchResult.components.ProgressBar
import com.mercadolibre.challenge.presentation.components.MELIErrorText
import com.mercadolibre.challenge.presentation.searchResult.components.SearchResultContent

/**
 * This composable expects [paddingValues] to padding content in view, [model] the model to search,
 * [onDetailProduct] lambda that triggers to send detail product UI, [viewModel] that holds information
 * about search
 */
@Composable
fun SearchResult(
    paddingValues: PaddingValues,
    model: SearchModel,
    onDetailProduct:(detail: Results) -> Unit = {},
    viewModel: SearchResultViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.searchProducts(siteId = model.siteId, product = model.search)
    }
    val response = viewModel.searchResultViewState.collectAsState(initial = Response.Loading)
    when (val searchResponse = response.value) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            searchResponse.data.results?.let { list ->
                SearchResultContent(
                    paddingValues = paddingValues,
                    onDetailProduct = onDetailProduct,
                    listResult = list,
                )
            }
        }
        is Response.Failure -> {
            MELIErrorText(searchResponse.exception?.message!!, paddingValues)
        }

        else -> {}
    }
}
