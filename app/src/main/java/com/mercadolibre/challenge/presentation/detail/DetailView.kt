package com.mercadolibre.challenge.presentation.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.components.DefaultTopBar
import com.mercadolibre.challenge.presentation.detail.component.DetailContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(
    navController: NavHostController = rememberNavController(),
    results: Results,
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = R.string.detail_product,
                navController = navController,
                upAvailable = true
            )
        },
        content = {
            DetailContent(paddingValues = it, results = results)
        }
    )
}
