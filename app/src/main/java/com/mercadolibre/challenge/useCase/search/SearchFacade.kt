package com.mercadolibre.challenge.useCase.search

/**
 * Represent the facade for use case at invokes services
 */
data class SearchFacade(
    /**
     * Represent variable to call search invoke
     */
    val searchUseCase: SearchUseCase
)
