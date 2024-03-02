package com.mercadolibre.challenge.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.presentation.components.MELIErrorText
import com.mercadolibre.challenge.presentation.intent.SearchDashboardIntent
import com.mercadolibre.challenge.presentation.intent.SiteDashboardIntent
import com.mercadolibre.challenge.presentation.search.components.SearchViewContent
import com.mercadolibre.challenge.presentation.searchResult.components.ProgressBar

@Composable
fun SitesViewState(
    viewModel: SearchViewModel,
    paddingValues: PaddingValues,
    valueTextField: String,
) {
    LaunchedEffect(Unit) {
        viewModel.sitesIntent.send(SiteDashboardIntent.SearchSites)
    }
    val response = viewModel.sites.collectAsState(Response.Loading)
    when (val result = response.value) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            SearchViewContent(
                paddingValues = paddingValues,
                viewModel = viewModel,
                valueTextField = valueTextField,
                list = result.data
            )
        }
        is Response.Failure -> {
            MELIErrorText(result.exception?.message!!, paddingValues)
        }
    }
}
