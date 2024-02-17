package com.mercadolibre.challenge.useCase.sites

import com.mercadolibre.challenge.domain.repository.sites.SiteRepository
import javax.inject.Inject

/**
 * Sites use case to invoke repository
 */
class SitesUseCase @Inject constructor(private val repository: SiteRepository) {
    /**
     * Invoke to site in the repository
     */
    suspend operator fun invoke() = repository.getSites()
}
