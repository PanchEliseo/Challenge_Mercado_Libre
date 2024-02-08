package com.mercadolibre.challenge.use_case.sites

/**
 * Represent the facade for use case at invokes services
 */
data class SitesFacade(
    /**
     * Represent variable to call sites invoke
     */
    val sitesUseCase: SitesUseCase
)
