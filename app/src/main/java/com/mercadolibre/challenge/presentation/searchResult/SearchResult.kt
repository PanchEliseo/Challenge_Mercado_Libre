package com.mercadolibre.challenge.presentation.searchResult

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.presentation.searchResult.components.SearchResultContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultView(
    navController: NavHostController = rememberNavController(),
    textSearch: String,
) {
    Scaffold(
        topBar = {
            DefaultTopBar(navController)
        },
        content = {
            SearchResult(
                paddingValues = it,
                navController = navController,
                product = textSearch)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(navController: NavHostController? = null) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.result_search))
        },
        navigationIcon = {
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "TopBar")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Yellow)
    )
}