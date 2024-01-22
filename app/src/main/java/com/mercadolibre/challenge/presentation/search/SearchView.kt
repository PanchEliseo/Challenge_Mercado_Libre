package com.mercadolibre.challenge.presentation.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.components.DefaultTopBar
import com.mercadolibre.challenge.presentation.search.components.ButtonSearch
import com.mercadolibre.challenge.presentation.search.components.SearchViewContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    navController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val valueTextField = viewModel.textValueChange.observeAsState(initial = "")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = R.string.search_label,
                navController = navController,
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
                navController = navController
            )
        }
    )
}