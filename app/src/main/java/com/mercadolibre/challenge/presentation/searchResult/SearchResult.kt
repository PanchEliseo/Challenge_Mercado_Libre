package com.mercadolibre.challenge.presentation.searchResult

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.model.SearchModel
import com.mercadolibre.challenge.presentation.components.DefaultTopBar

/**
 * This composable expects [onBack] lambda that triggers back UI, [onDetailProduct] lambda
 * that triggers to send detail product UI [model] SearchModel that search in service
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultView(
    onBack:() -> Unit = {},
    onDetailProduct:(detail: Results) -> Unit = {},
    model: SearchModel,
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = R.string.result_search,
                onBack = onBack,
                upAvailable = true
            )
        },
        content = {
            SearchResult(
                paddingValues = it,
                onDetailProduct = onDetailProduct,
                model = model)
        }
    )
}
