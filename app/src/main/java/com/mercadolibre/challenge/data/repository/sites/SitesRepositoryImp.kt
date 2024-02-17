package com.mercadolibre.challenge.data.repository.sites

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.sites.SiteRepository
import com.mercadolibre.challenge.domain.retrofit.SearchService
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import java.net.UnknownHostException

/**
 * Repository implement to call service and receive response
 * @param service The service for sites
 */
class SitesRepositoryImp(private val service: SearchService): SiteRepository {
    /**
     * Function to call sites service and process the response data
     */
    override suspend fun getSites(): Response<MutableList<ResponseSites>> {
        Response.Loading
        return try {
            val response = service.getSites()
            response.sortBy {
                it.name
            }
            Response.Success(response)
        } catch (e: UnknownHostException) {
            Response.Failure(e)
        }
    }
}
