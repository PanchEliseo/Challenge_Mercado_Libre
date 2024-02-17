package com.mercadolibre.challenge.presentation.searchResult.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.mercadolibre.challenge.domain.retrofit.search.Results

/**
 * This composable expects [paddingValues] to padding content in screen, [onDetailProduct] lambda
 * that triggers to send detail product UI, [listResult] this list result of search after call to
 * service
 */
@Composable
fun SearchResultContent(
    paddingValues: PaddingValues,
    onDetailProduct:(detail: Results) -> Unit = {},
    listResult: List<Results>,
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .wrapContentSize()
            .semantics { contentDescription = "Search Result View" }
    ) {
        items(
            items = listResult
        ) {result ->
            ItemSearchResult(
                onDetailProduct = onDetailProduct,
                results = result
            )
        }
    }
}
