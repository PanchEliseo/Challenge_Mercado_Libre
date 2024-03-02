package com.mercadolibre.challenge.presentation.intent

sealed class SearchDashboardIntent {
    data class SearchProduct(val product: String, val siteId: String): SearchDashboardIntent()
}
