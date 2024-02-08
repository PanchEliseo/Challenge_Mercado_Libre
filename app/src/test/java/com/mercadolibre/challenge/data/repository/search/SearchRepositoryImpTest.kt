package com.mercadolibre.challenge.data.repository.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.SearchService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SearchRepositoryImpTest {

    private val service = mockk<SearchService>(relaxed = true)
    private val repositoryImp = SearchRepositoryImp(service)

    @Test
    fun `should emit result when service response is success`() = runTest {
        val responseBuilder = RequestSearch.RequestBuilder("Motorola")
        responseBuilder.siteId("MLM")
        val response = repositoryImp.search(product = responseBuilder.build())

        coVerify {
            service.search(any(), any())
        }
        val resp = when (response){
            is Response.Success -> {
                response.data.results
            }

            else -> {
                listOf()
            }
        }

        assertNotNull(resp)
    }

    @Test
    fun `should emit empty when service response is success`() = runTest {
        val responseBuilder = RequestSearch.RequestBuilder("")
        responseBuilder.siteId("")
        val response = repositoryImp.search(responseBuilder.build())

        coVerify {
            service.search(any(), any())
        }
        val resp = when (response){
            is Response.Success -> {
                response.data.results
            }

            else -> {
                listOf()
            }
        }
        assertEquals(resp?.size, 0)
    }

    @Test
    fun `should emit empty when service response exception`() = runTest {
        val message = "Exception"
        coEvery {
            service.search(any(), any())
        } throws Exception(message)
        val responseBuilder = RequestSearch.RequestBuilder("")
        responseBuilder.siteId("")
        val resp = when (val response = repositoryImp.search(responseBuilder.build())){
            is Response.Failure -> {
                response.exception?.message
            }

            else -> {
                ""
            }
        }
        coVerify {
            service.search(any(), any())
        }
        assertEquals(message, resp)
    }
}