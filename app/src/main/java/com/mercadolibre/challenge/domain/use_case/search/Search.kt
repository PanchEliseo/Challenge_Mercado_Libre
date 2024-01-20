package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.repository.SearchRepository
import javax.inject.Inject

class Search @Inject constructor(private val repository: SearchRepository) {
    suspend operator fun invoke(product: String) = repository.search(product)
}