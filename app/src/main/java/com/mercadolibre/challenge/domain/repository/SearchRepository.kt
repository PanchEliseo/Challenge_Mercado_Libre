package com.mercadolibre.challenge.domain.repository

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse

interface SearchRepository {
    suspend fun search(product: String): Response<SearchResponse>
}