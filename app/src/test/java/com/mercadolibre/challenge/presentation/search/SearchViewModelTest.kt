package com.mercadolibre.challenge.presentation.search

import app.cash.turbine.test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
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

    @Test
    fun onChangeValueChange() = runTest {
        viewModel.onChangeValueChange("Motorola")
        viewModel.textValueChange.test {
            assertEquals(viewModel.textValueChange.value, awaitItem())
        }
    }
}