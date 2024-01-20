package com.mercadolibre.challenge.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mercadolibre.challenge.presentation.searchResult.SearchResultView

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.RESULT,
        startDestination = ResultScreen.Result.route
    ) {
        composable(
            route = ResultScreen.Result.route,
            arguments = listOf(navArgument("textSearch"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("textSearch")?.let {text ->
                SearchResultView(navController, text)
            }
        }
    }
}

sealed class ResultScreen(val route: String) {
    object Result: ResultScreen(route = "result/search/{textSearch}") {
        fun searchText(textSearch: String) = "result/search/$textSearch"
    }
}