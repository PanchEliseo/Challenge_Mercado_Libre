package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.repository.SearchRepository
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
    suspend operator fun invoke(request: RequestSearch) = repository.search(request.product)
}