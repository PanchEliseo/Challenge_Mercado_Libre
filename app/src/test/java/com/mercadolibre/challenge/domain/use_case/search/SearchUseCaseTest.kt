package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.repository.SearchRepository
import io.mockk.mockk
import org.junit.Test

class SearchUseCaseTest {

    private val repository = mockk<SearchRepository>(relaxed = true)

    @Test
    fun setDataSearchUseCaseModel() {
        val searchUseCase = SearchUseCase(search = Search(repository))
        searchUseCase.search
    }
}
