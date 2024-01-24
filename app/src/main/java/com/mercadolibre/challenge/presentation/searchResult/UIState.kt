package com.mercadolibre.challenge.presentation.searchResult

import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse

/**
 * Represent a state ui when service response
 */
sealed class UIState {
    /**
     * Represent that you are loading information and notified the UI
     */
    object Loading: UIState()

    /**
     * Represent that you are receiving response success and notified the UI
     * @property result The response data
     */
    data class Success(val result: SearchResponse): UIState()

    /**
     * Represent that you are receiving message failure and notified the UI
     * @property message The message error
     */
    data class Failure(val message: String): UIState()
}
