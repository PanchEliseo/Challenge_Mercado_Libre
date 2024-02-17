package com.mercadolibre.challenge.useCase.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.model.ValidationException
import com.mercadolibre.challenge.domain.repository.search.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.utils.EMPTY_LIST
import com.mercadolibre.challenge.utils.SERVER_FAILURE
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
        val responseFinal: Response<SearchResponse>
        when (val response = repository.search(request)) {
            is Response.Success -> {
                val data = response.data.results ?: emptyList()
                responseFinal = if (data.isNotEmpty()) {
                    response
                } else {
                    Response.Failure(ValidationException.ServerException(EMPTY_LIST))
                }
            }
            is Response.Failure -> {
                val exception = response.exception ?: ValidationException.ServerException(SERVER_FAILURE)
                responseFinal = Response.Failure(exception)
            }
            else -> {
                responseFinal = Response.Failure(ValidationException.ServerException(EMPTY_LIST))
            }
        }
        return responseFinal
    }
}
