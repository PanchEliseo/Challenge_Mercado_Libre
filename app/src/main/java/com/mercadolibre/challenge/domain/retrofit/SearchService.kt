package com.mercadolibre.challenge.domain.retrofit

import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import com.mercadolibre.challenge.utils.API_BODY_SEARCH
import com.mercadolibre.challenge.utils.SEARCH_TEXT
import com.mercadolibre.challenge.utils.API_BODY_SITES
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
    @GET(API_BODY_SEARCH)
    suspend fun search(
        @Path(value = "site_id") siteId: String,
        @Query(SEARCH_TEXT) search: String
    ): SearchResponse

    /**
     * Function to call sites service
     */
    @GET(API_BODY_SITES)
    suspend fun getSites(): MutableList<ResponseSites>
}