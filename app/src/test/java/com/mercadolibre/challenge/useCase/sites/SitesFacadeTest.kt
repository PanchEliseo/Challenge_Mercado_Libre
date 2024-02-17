package com.mercadolibre.challenge.useCase.sites

import com.mercadolibre.challenge.domain.repository.sites.SiteRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SitesFacadeTest {

    private val repository = mockk<SiteRepository>(relaxed = true)
    private lateinit var sitesUseCaseFacade: SitesFacade

    @Before
    fun setUp() {
        sitesUseCaseFacade = SitesFacade(sitesUseCase = SitesUseCase(repository))
    }

    @Test
    fun setDataSitesUseCaseModel() = runTest {
        repository.getSites()
        coVerify(exactly = 1) {
            sitesUseCaseFacade.sitesUseCase()
        }
    }
}
