package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.repository.SearchRepository
import javax.inject.Inject

/**
 * Search use case to invoke repository
 * @param repository The search repository
 */
class Search @Inject constructor(private val repository: SearchRepository) {
    /**
     * Invoke to search in the repository
     * @param product The product to search
     */
    suspend operator fun invoke(product: String) = repository.search(product)
}