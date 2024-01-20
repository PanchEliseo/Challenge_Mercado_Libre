package com.mercadolibre.challenge.domain.retrofit

data class SearchListResponse<T>(
    val results: List<T>
)
