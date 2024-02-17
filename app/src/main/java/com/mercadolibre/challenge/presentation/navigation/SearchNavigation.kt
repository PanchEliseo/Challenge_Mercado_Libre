package com.mercadolibre.challenge.presentation.navigation

/**
 * Represent a navigation for composable
 * @param route The text for route
 */
sealed class SearchNavigation(val route: String) {
    /**
     * Represent the route for search result
     */
    object Result: SearchNavigation(route = "result/search/{modelSearch}")

    /**
     * Represent the route for detail product
     */
    object Detail: SearchNavigation(route = "detail/search/{detailProduct}")
}
