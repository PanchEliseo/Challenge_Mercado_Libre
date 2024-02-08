package com.mercadolibre.challenge.use_case.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.repository.search.SearchRepository
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.use_case.search.SearchFacade
import com.mercadolibre.challenge.use_case.search.SearchUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchFacadeTest {

    private val repository = mockk<SearchRepository>(relaxed = true)
    private lateinit var searchUseCaseFacade: SearchFacade

    @Before
    fun setUp() {
        searchUseCaseFacade = SearchFacade(searchUseCase = SearchUseCase(repository))
    }

    @Test
    fun setDataSearchUseCaseModel() = runTest {
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
        coEvery {
            repository.search(any())
        } returns Response.Success(response)
        val request = RequestSearch.RequestBuilder("Motorola")
        searchUseCaseFacade.searchUseCase(request.build())
        coVerify(exactly = 1) {
            repository.search(any())
        }
    }
}
