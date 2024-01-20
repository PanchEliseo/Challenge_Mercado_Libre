package com.mercadolibre.challenge.domain.retrofit

import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.utils.API_BODY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    @Headers("Content-Type: application/json")
    @GET(API_BODY)
    suspend fun search(@Query("q") search: String): SearchResponse
}