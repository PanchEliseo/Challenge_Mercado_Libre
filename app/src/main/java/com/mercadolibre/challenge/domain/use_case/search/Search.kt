package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import javax.inject.Inject

/**
 * Search use case to invoke repository
 * @param repository The search repository
 */
class Search @Inject constructor(private val repository: SearchRepository) {
    /**
     * Invoke to search in the repository
     * @param request The data class with request to search
     */
    suspend operator fun invoke(request: RequestSearch): Response<SearchResponse> {
        return if (!request.product.contains(" ")) {
            repository.search(request.product)
        } else {
            Response.Failure(Exception("Campo de busqueda vacio"))
        }
    }
}