package com.mercadolibre.challenge.presentation.searchResult

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.presentation.searchResult.components.ProgressBar
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
    val response = viewModel.searchResultViewState.collectAsState(initial = Response.Loading)
    when (val searchResponse = response.value) {
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            searchResponse.data.results?.let { list ->
                SearchResultContent(
                    paddingValues = paddingValues,
                    navController = navController,
                    listResult = list,
                )
            }
        }
        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                searchResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG,
            ).show()
        }
    }
}