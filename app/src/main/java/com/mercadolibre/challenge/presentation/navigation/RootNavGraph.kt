package com.mercadolibre.challenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mercadolibre.challenge.presentation.search.SearchView

/**
 * This composable expects [navController] for navigation between composable
 */
@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SEARCH
    ) {
        searchNavGraph(navController)
        composable(route = Graph.SEARCH) {
            SearchView(
                onSearch = {
                    navController.navigate(
                        route = SearchNavigation.Result.searchText(it)
                    )
                }
            )
        }
    }
}