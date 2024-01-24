package com.mercadolibre.challenge.presentation.searchResult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.use_case.search.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [SearchResultViewModel] holds information about search result of product. It also knows to call
 * service based in search product
 * @param searchUseCase The use case to call service
 */
@HiltViewModel
class SearchResultViewModel @Inject constructor(private val searchUseCase: SearchUseCase): ViewModel() {

    /**
     * Search result state
     */
    private val _searchResultViewState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)
    val searchResultViewState = _searchResultViewState.asStateFlow()

    /**
     * Search product in service
     * @param product The product to search
     */
    fun searchProducts(product: String) {
        viewModelScope.launch {
            _searchResultViewState.emit(UIState.Loading)
            when(val response = searchUseCase.search(product)) {
                is Response.Success -> {
                    _searchResultViewState.emit(UIState.Success(response.data))
                }
                is Response.Failure -> {
                    _searchResultViewState.emit(UIState.Failure(response.exception?.message ?: "Error en el servicio"))
                }

                else -> {}
            }
        }
    }
}
