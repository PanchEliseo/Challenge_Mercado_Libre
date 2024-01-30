package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.repository.SearchRepository
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SearchTest {

    private val repository = mockk<SearchRepository>(relaxed = true)

    @Test
    fun invokeSearchUseCase() = runTest {
        val search = Search(repository)
        val request = RequestSearch.RequestBuilder("")
        search.invoke(request.build())
    }

}