package com.mercadolibre.challenge.domain.repository

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.retrofit.SearchService
import java.lang.Exception

/**
 * Repository implement to call service and receive response
 * @param service The service for search product
 */
class SearchRepositoryImp(private val service: SearchService): SearchRepository {
    /**
     * Function to call search service and process the response data
     * @param product The type product to search
     */
    override suspend fun search(product: String): Response<SearchResponse> {
        Response.Loading
        return try {
            val result = service.search(product)
            Response.Success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}