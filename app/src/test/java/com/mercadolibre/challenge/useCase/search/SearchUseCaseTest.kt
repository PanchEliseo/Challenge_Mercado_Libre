package com.mercadolibre.challenge.useCase.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.search.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchUseCaseTest {

    private val repository = mockk<SearchRepository>(relaxed = true)
    private lateinit var searchUseCase: SearchUseCase

    @Before
    fun setUp() {
        searchUseCase = SearchUseCase(repository)
    }

    @Test
    fun `invoke repository when success and list get results`() = runTest {
        val response = SearchResponse(
            results = listOf(
                Results(
                    title = "Test",
                    price = 110.50,
                    thumbnail = "",
                    currencyId = "",
                    attributes = listOf()
                )
            )
        )
        coEvery { repository.search(any()) } returns Response.Success(response)
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when success and empty list`() = runTest {
        val response = SearchResponse(results = emptyList())
        coEvery { repository.search(any()) } returns Response.Success(response)
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when success and null result`() = runTest {
        val response = SearchResponse(results = null)
        coEvery { repository.search(any()) } returns Response.Success(response)
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when failure with exception`() = runTest {
        coEvery { repository.search(any()) } returns Response.Failure(Exception())
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when failure with exception message`() = runTest {
        coEvery { repository.search(any()) } returns Response.Failure(Exception("Error"))
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when failure with exception null`() = runTest {
        coEvery { repository.search(any()) } returns Response.Failure(null)
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

    @Test
    fun `invoke repository when loading`() = runTest {
        coEvery { repository.search(any()) } returns Response.Loading
        val request = RequestSearch.RequestBuilder("")
        searchUseCase.invoke(request.build())
        coVerify(exactly = 1) { repository.search(any()) }
    }

}
