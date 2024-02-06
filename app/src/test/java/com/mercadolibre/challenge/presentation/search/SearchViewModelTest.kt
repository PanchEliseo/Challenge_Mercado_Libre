package com.mercadolibre.challenge.presentation.search

import app.cash.turbine.test
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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        viewModel = SearchViewModel()
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun onChangeValueChange() = runTest {
        viewModel.onChangeValueChange("Motorola")
        viewModel.textValueChange.test {
            assertEquals(viewModel.textValueChange.value, awaitItem())
        }
    }

    @Test
    fun onChangeValueSiteId() = runTest {
        viewModel.onChangeValueSiteId("MLM")
        viewModel.textSiteId.test {
            assertEquals(viewModel.textSiteId.value, awaitItem())
        }
    }
}