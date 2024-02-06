package com.mercadolibre.challenge.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mercadolibre.challenge.domain.retrofit.search.Results
import com.mercadolibre.challenge.presentation.model.SearchModel
import com.mercadolibre.challenge.presentation.detail.DetailView
import com.mercadolibre.challenge.presentation.searchResult.SearchResultView

/**
 * Extension function for navigation composable expects [navController] to navigation
 */
fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.RESULT,
        startDestination = SearchNavigation.Result.route
    ) {
        composable(route = SearchNavigation.Result.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<SearchModel>("Model")
            result?.let { searchModel ->
                SearchResultView(
                    onBack = { navController.popBackStack() },
                    onDetailProduct = { detail ->
                        navController.currentBackStackEntry?.savedStateHandle?.set("Detail", detail)
                        navController.navigate(route = SearchNavigation.Detail.route)
                    },
                    model = searchModel,
                )
            }
        }

        composable(route = SearchNavigation.Detail.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Results>("Detail")
            result?.let {
                DetailView(
                    onBack = {
                        navController.popBackStack()
                    },
                    results = it
                )
            }
        }
    }
}
