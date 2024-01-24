package com.mercadolibre.challenge.presentation.searchResult

import app.cash.turbine.test
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.use_case.search.SearchUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SearchResultViewModelTest {

    private val searchUseCase = mockk<SearchUseCase>(relaxed = true)
    private lateinit var viewModel: SearchResultViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        viewModel = SearchResultViewModel(searchUseCase = searchUseCase)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun `should emit result when service response is success`() = runTest {
        coEvery {
            searchUseCase.search(any())
        } returns Response.Success(SearchResponse())
        viewModel.searchProducts("Motorola")
        coVerify {
            searchUseCase.search(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit empty when service response is success`() = runTest {
        coEvery {
            searchUseCase.search(any())
        } returns Response.Success(SearchResponse())
        viewModel.searchProducts("")
        coVerify {
            searchUseCase.search(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure when service response is Exception`() = runTest {
        coEvery {
            searchUseCase.search(any())
        } returns Response.Failure(Exception())
        viewModel.searchProducts("")
        coVerify {
            searchUseCase.search(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure with product when service response is Exception`() = runTest {
        coEvery {
            searchUseCase.search(any())
        } returns Response.Failure(Exception("Exception"))
        viewModel.searchProducts("Motorola")
        coVerify {
            searchUseCase.search(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure with product when service response is Exception null`() = runTest {
        coEvery {
            searchUseCase.search(any())
        } returns Response.Failure(null)
        viewModel.searchProducts("Motorola")
        coVerify {
            searchUseCase.search(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }
}