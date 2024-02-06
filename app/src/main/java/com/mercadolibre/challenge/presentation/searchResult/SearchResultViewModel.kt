package com.mercadolibre.challenge.presentation.searchResult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.challenge.domain.model.RequestSearch
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.use_case.search.SearchFacade
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [SearchResultViewModel] holds information about search result of product. It also knows to call
 * service based in search product
 * @param searchFacade The use case to call service
 */
@HiltViewModel
class SearchResultViewModel @Inject constructor(private val searchFacade: SearchFacade): ViewModel() {

    /**
     * Search result state
     */
    private val _searchResultViewState: MutableStateFlow<Response<SearchResponse>> = MutableStateFlow(Response.Loading)
    val searchResultViewState = _searchResultViewState.asStateFlow()

    /**
     * Search product in service
     * @param product The product to search
     */
    fun searchProducts(product: String, siteId: String) {
        viewModelScope.launch {
            _searchResultViewState.emit(Response.Loading)
            val request = RequestSearch.RequestBuilder(product)
                .siteId(siteId.uppercase())
                .build()
            _searchResultViewState.emit(searchFacade.searchUseCase(request))
        }
    }
}
