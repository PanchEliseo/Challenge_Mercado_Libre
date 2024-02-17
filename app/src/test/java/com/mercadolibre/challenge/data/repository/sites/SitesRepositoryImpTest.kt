package com.mercadolibre.challenge.data.repository.sites

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.SearchService
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.net.UnknownHostException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SitesRepositoryImpTest {

    private val service = mockk<SearchService>(relaxed = true)
    private val repositoryImp = SitesRepositoryImp(service)

    @Test
    fun `should emit result when service response is success`() = runTest {
        coEvery {
            service.getSites()
        } returns mutableListOf(
            ResponseSites(
                defaultCurrencyId = "PEN",
                id = "MPE",
                name = "Perú"
            )
        )
        val resp = when (val response = repositoryImp.getSites()) {
            is Response.Success -> {
                response.data
            }
            else -> {
                emptyList()
            }
        }
        coVerify {
            service.getSites()
        }
        assertNotNull(resp)
    }

    @Test
    fun `should emit empty when service response exception`() = runTest {
        val message = "Exception"
        coEvery {
            service.getSites()
        } throws UnknownHostException(message)
        val resp = when (val response = repositoryImp.getSites()) {
            is Response.Failure -> {
                response.exception?.message
            }
            else -> {
                ""
            }
        }
        coVerify {
            service.getSites()
        }
        assertEquals(resp, message)
    }

}
