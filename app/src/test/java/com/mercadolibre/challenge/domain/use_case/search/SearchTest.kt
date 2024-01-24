package com.mercadolibre.challenge.domain.use_case.search

import com.mercadolibre.challenge.domain.repository.SearchRepository
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SearchTest {

    private val repository = mockk<SearchRepository>(relaxed = true)

    @Test
    fun invokeSearchUseCase() = runTest {
        val search = Search(repository)
        search.invoke("")
    }

}