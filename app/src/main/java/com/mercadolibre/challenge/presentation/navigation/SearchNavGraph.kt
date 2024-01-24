package com.mercadolibre.challenge.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mercadolibre.challenge.domain.retrofit.search.Results
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
        composable(
            route = SearchNavigation.Result.route,
            arguments = listOf(navArgument("textSearch"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("textSearch")?.let {text ->
                SearchResultView(
                    onBack = { navController.popBackStack() },
                    onDetailProduct = { detail ->
                        navController.currentBackStackEntry?.savedStateHandle?.set("Detail", detail)
                        navController.navigate(route = SearchNavigation.Detail.route)
                    },
                    textSearch = text,
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
