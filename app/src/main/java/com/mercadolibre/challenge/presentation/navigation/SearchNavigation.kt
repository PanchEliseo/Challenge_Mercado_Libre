package com.mercadolibre.challenge.presentation.navigation

/**
 * Represent a navigation for composable
 * @param route The text for route
 */
sealed class SearchNavigation(val route: String) {
    /**
     * Represent the route for search result
     */
    object Result: SearchNavigation(route = "result/search/{textSearch}") {
        /**
         * Function to share parameter in composable
         * @param textSearch The text to share
         */
        fun searchText(textSearch: String) = "result/search/$textSearch"
    }

    /**
     * Represent the route for detail product
     */
    object Detail: SearchNavigation(route = "detail/search/{detailProduct}")
}