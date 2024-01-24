package com.mercadolibre.challenge.domain.repository

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
        val response = repositoryImp.search("Motorola")

        coVerify {
            service.search(any())
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
        val response = repositoryImp.search("")

        coVerify {
            service.search(any())
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
            service.search(any())
        } throws Exception("Exception")
        val resp = when (val response = repositoryImp.search("")){
            is Response.Failure -> {
                response.exception?.message
            }

            else -> {
                ""
            }
        }
        coVerify {
            service.search(any())
        }
        assertEquals("Exception", resp)
    }
}