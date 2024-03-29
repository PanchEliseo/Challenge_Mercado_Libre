package com.mercadolibre.challenge.data.repository.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.search.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.retrofit.SearchService
import java.net.UnknownHostException

/**
 * Repository implement to call service and receive response
 * @param service The service for search product
 */
class SearchRepositoryImp(private val service: SearchService): SearchRepository {
    /**
     * Function to call search service and process the response data
     * @param product The type product to search
     */
    override suspend fun search(product: RequestSearch): Response<SearchResponse> {
        Response.Loading
        return try {
            val result = service.search(siteId = product.siteId, search = product.product)
            Response.Success(result)
        } catch (e: UnknownHostException) {
            Response.Failure(e)
        }
    }
}
