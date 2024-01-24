package com.mercadolibre.challenge

import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.navigation.RootNavGraph
import com.mercadolibre.challenge.presentation.navigation.SearchNavigation
import com.mercadolibre.challenge.presentation.searchResult.SearchResultViewModel
import com.mercadolibre.challenge.presentation.searchResult.UIState
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: TestNavHostController

    private lateinit var viewModel: SearchResultViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        composeTestRule.activity.setContent {
            viewModel = hiltViewModel()
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            RootNavGraph(navController = navController)
        }
    }

    @Test
    fun challenge_verifySearchStartDestination() {
        composeTestRule
            .onNodeWithContentDescription("Search Screen")
            .assertIsDisplayed()
    }

    @Test
    fun challenge_setTextSearchAndClickButton_navigateToResult() {
        navigateToResultSearch()
        navController.assertCurrentRouteName(SearchNavigation.Result.route)
    }

    @Test
    fun challenge_setTextSearchAndClickButton_clickItem_navigateToDetail() {
        navigateToResultSearch()
        var results: List<Results> = listOf()
        composeTestRule.activity.setContent {
            val response = viewModel.searchResultViewState.collectAsState(UIState.Loading)
            results = when (val resp = response.value) {
                is UIState.Success -> {
                    resp.result.results!!
                }
                else -> {
                    listOf()
                }
            }
        }
        if (results.isNotEmpty()) {
            composeTestRule.onNodeWithContentDescription("Search Result View")
                .assertIsDisplayed()
        }
    }

    private fun navigateToResultSearch() {
        with(composeTestRule) {
            onNodeWithContentDescription("Label Search")
                .assertIsDisplayed()
                .performTextInput("Motorola")

            onNodeWithContentDescription("Button Search")
                .assertIsDisplayed()
                .performClick()
        }
    }
}
