package com.mercadolibre.challenge.presentation.searchResult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.use_case.search.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(private val searchUseCase: SearchUseCase): ViewModel() {

    private val _searchResultViewState = MutableSharedFlow<Response<SearchResponse>>()
    val searchResultViewState: SharedFlow<Response<SearchResponse>> = _searchResultViewState

    fun searchProducts(product: String) = viewModelScope.launch {
        _searchResultViewState.emit(searchUseCase.search(product))
    }
}
