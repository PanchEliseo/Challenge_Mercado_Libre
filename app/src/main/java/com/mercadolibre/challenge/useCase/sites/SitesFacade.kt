package com.mercadolibre.challenge.useCase.sites

/**
 * Represent the facade for use case at invokes services
 */
data class SitesFacade(
    /**
     * Represent variable to call sites invoke
     */
    val sitesUseCase: SitesUseCase
)
