package com.mercadolibre.challenge.presentation.search

import app.cash.turbine.test
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.use_case.sites.SitesFacade
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
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel
    private val sitesFacade = mockk<SitesFacade>(relaxed = true)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        viewModel = SearchViewModel(sitesFacade)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `on change value with text`() = runTest {
        viewModel.onChangeValueChange("Motorola")
        viewModel.textValueChange.test {
            assertEquals(viewModel.textValueChange.value, awaitItem())
        }
    }

    @Test
    fun `on change value with empty text`() = runTest {
        viewModel.onChangeValueChange("")
        viewModel.textValueChange.test {
            assertEquals(viewModel.textValueChange.value, awaitItem())
        }
    }

    @Test
    fun `on change value siteId`() = runTest {
        viewModel.onChangeValueSiteId("MLM")
        viewModel.textSiteId.test {
            assertEquals(viewModel.textSiteId.value, awaitItem())
        }
    }

    @Test
    fun `should emit result when service response is success`() = runTest {
        coEvery {
            sitesFacade.sitesUseCase()
        } returns Response.Success(mutableListOf())
        viewModel.getSites()
        coVerify {
            sitesFacade.sitesUseCase()
        }
        viewModel.sites.test {
            assertEquals(viewModel.sites.value, awaitItem())
        }
    }

    @Test
    fun `should emit result when service response is failure`() = runTest {
        coEvery {
            sitesFacade.sitesUseCase()
        } returns Response.Failure(Exception())
        viewModel.getSites()
        coVerify {
            sitesFacade.sitesUseCase()
        }
        viewModel.sites.test {
            assertEquals(viewModel.sites.value, awaitItem())
        }
    }
}