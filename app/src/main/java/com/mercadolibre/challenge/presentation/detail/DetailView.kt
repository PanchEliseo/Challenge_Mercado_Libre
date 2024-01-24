package com.mercadolibre.challenge.presentation.detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mercadolibre.challenge.R
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.components.DefaultTopBar
import com.mercadolibre.challenge.presentation.detail.component.DetailContent

/**
 * This composable expects [onBack] lambda that triggers to back view, [results] object with result
 * of search
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(
    onBack:() -> Unit = {},
    results: Results,
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = R.string.detail_product,
                onBack = onBack,
                upAvailable = true
            )
        },
        content = {
            DetailContent(paddingValues = it, results = results)
        }
    )
}
