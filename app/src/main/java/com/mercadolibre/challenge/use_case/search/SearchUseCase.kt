package com.mercadolibre.challenge.use_case.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.utils.EMPTY_LIST
import javax.inject.Inject

/**
 * Search use case to invoke repository
 * @param repository The search repository
 */
class SearchUseCase @Inject constructor(private val repository: SearchRepository) {
    /**
     * Invoke to search in the repository
     * @param request The data class with request to search
     */
    suspend operator fun invoke(request: RequestSearch): Response<SearchResponse> {
        when (val response = repository.search(request.product)) {
            is Response.Success -> {
                val data = response.data.results ?: emptyList()
                return if (data.isNotEmpty()) {
                    response
                } else {
                    Response.Failure(Exception(EMPTY_LIST))
                }
            }
            is Response.Failure -> {
                val exception = response.exception ?: Exception()
                return Response.Failure(exception)
            }
            else -> {
                return Response.Failure(Exception(EMPTY_LIST))
            }
        }
    }
}