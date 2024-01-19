package com.mercadolibre.challenge.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mercadolibre.challenge.presentation.resultSearch.ResultSearchView

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.RESULT,
        startDestination = ResultScreen.Result.route
    ) {
        composable(route = ResultScreen.Result.route) {
            ResultSearchView(navController)
        }
    }
}

sealed class ResultScreen(val route: String) {
    object Result: ResultScreen(route = "result/search")
}