package com.mercadolibre.challenge.domain.repository.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse

/**
 * Interface to call search service
 */
interface SearchRepository {
    /**
     * Function to search product in service
     * @param product The type product to search
     */
    suspend fun search(product: RequestSearch): Response<SearchResponse>
}