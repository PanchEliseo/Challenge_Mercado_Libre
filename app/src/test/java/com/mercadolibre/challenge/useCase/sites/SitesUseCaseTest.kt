package com.mercadolibre.challenge.useCase.sites

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.sites.SiteRepository
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SitesUseCaseTest {

    private val repository = mockk<SiteRepository>(relaxed = true)
    private lateinit var siteUseCase: SitesUseCase

    @Before
    fun setUp() {
        siteUseCase = SitesUseCase(repository)
    }

    @Test
    fun `invoke repository when success`() = runTest {
        coEvery {
            repository.getSites()
        } returns Response.Success(mutableListOf(ResponseSites()))
        siteUseCase.invoke()
        coVerify(exactly = 1) {
            repository.getSites()
        }
    }

    @Test
    fun `invoke repository when failure`() = runTest {
        coEvery {
            repository.getSites()
        } returns Response.Failure(Exception())
        siteUseCase.invoke()
        coVerify(exactly = 1) {
            repository.getSites()
        }
    }

}
