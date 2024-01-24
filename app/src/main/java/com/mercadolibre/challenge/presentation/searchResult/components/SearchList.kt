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
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.domain.retrofit.search.Results

@Composable
fun SearchResultContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
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
            ItemSearchResult(navController = navController, results = result)
        }
    }
}