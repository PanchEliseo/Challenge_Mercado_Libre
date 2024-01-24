package com.mercadolibre.challenge.domain.repository

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse

/**
 * Interface to call service
 */
interface SearchRepository {
    /**
     * Function to search product in service
     * @param product The type product to search
     */
    suspend fun search(product: String): Response<SearchResponse>
}