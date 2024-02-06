package com.mercadolibre.challenge.presentation.searchResult

import app.cash.turbine.test
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.use_case.search.SearchFacade
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SearchResultViewModelTest {

    private val searchFacade = mockk<SearchFacade>(relaxed = true)
    private lateinit var viewModel: SearchResultViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        viewModel = SearchResultViewModel(searchFacade = searchFacade)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should emit result when service response is success`() = runTest {
        coEvery {
            searchFacade.searchUseCase(any())
        } returns Response.Success(SearchResponse())
        viewModel.searchProducts(product = "Motorola", siteId = "MLM")
        coVerify {
            searchFacade.searchUseCase(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit empty when service response is success`() = runTest {
        coEvery {
            searchFacade.searchUseCase(any())
        } returns Response.Success(SearchResponse())
        viewModel.searchProducts("", "")
        coVerify {
            searchFacade.searchUseCase(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure when service response is Exception`() = runTest {
        coEvery {
            searchFacade.searchUseCase(any())
        } returns Response.Failure(Exception())
        viewModel.searchProducts("", "")
        coVerify {
            searchFacade.searchUseCase(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure with product when service response is Exception`() = runTest {
        coEvery {
            searchFacade.searchUseCase(any())
        } returns Response.Failure(Exception("Exception"))
        viewModel.searchProducts("Motorola", "MLM")
        coVerify {
            searchFacade.searchUseCase(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }

    @Test
    fun `should emit failure with product when service response is Exception null`() = runTest {
        coEvery {
            searchFacade.searchUseCase(any())
        } returns Response.Failure(null)
        viewModel.searchProducts("Motorola", "MLM")
        coVerify {
            searchFacade.searchUseCase(any())
        }
        viewModel.searchResultViewState.test {
            assertEquals(viewModel.searchResultViewState.value, awaitItem())
        }
    }
}