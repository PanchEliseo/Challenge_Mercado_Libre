package com.mercadolibre.challenge.domain.repository.sites

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites

/**
 * Interface to call sites service
 */
interface SiteRepository {
    /**
     * Function to get sites of service
     */
    suspend fun getSites(): Response<MutableList<ResponseSites>>
}