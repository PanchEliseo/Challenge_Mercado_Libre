package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.repository.SearchRepository
import com.mercadolibre.challenge.use_case.search.SearchFacade
import com.mercadolibre.challenge.use_case.search.SearchUseCase
import io.mockk.mockk
import org.junit.Test

class SearchFacadeTest {

    private val repository = mockk<SearchRepository>(relaxed = true)

    @Test
    fun setDataSearchUseCaseModel() {
        val searchUseCaseFacade = SearchFacade(searchUseCase = SearchUseCase(repository))
        searchUseCaseFacade.searchUseCase
    }
}
