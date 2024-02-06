package com.mercadolibre.challenge.domain.repository

import com.mercadolibre.challenge.data.repository.SearchRepositoryImp
import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.SearchService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

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

        Assert.assertNotNull(resp)
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
        Assert.assertEquals(resp?.size, 0)
    }

    @Test
    fun `should emit empty when service response exception`() = runTest {
        coEvery {
            service.search(any(), any())
        } throws Exception("Exception")
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
        assertEquals("Exception", resp)
    }
}