package com.mercadolibre.challenge.domain.retrofit

import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.utils.API_BODY
import com.mercadolibre.challenge.utils.SEARCH_TEXT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * ApiService for search product
 */
interface SearchService {
    /**
     * Function to call search service
     * @param search product text for search
     */
    @GET(API_BODY)
    suspend fun search(
        @Path(value = "site_id") siteId: String,
        @Query(SEARCH_TEXT) search: String
    ): SearchResponse
}