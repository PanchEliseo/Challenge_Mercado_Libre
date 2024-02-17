package com.mercadolibre.challenge.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.sites.ResponseSites
import com.mercadolibre.challenge.useCase.sites.SitesFacade
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [SearchViewModel] holds information about screen for search
 */
@HiltViewModel
class SearchViewModel @Inject constructor(private val sitesFacade: SitesFacade): ViewModel() {

    /**
     * Product state for search
     */
    private var _textValueChange: MutableStateFlow<String> = MutableStateFlow("")
    val textValueChange = _textValueChange.asStateFlow()

    /**
     * SiteID state for search
     */
    private var _textSiteId: MutableStateFlow<String> = MutableStateFlow("")
    val textSiteId = _textSiteId.asStateFlow()

    /**
     * Sites state for DropDownMenu
     */
    private var _sites: MutableStateFlow<Response<MutableList<ResponseSites>>> = MutableStateFlow(Response.Loading)
    val sites = _sites.asStateFlow()

    /**
     * Set the text for product to search on TextField
     * @param newTextValueChange value change
     */
    fun onChangeValueChange(newTextValueChange: String) {
        if (newTextValueChange.matches(Regex("^[a-zA-Z0-9_][a-zA-Z0-9_ ]*[a-zA-Z0-9_]*$"))) {
            _textValueChange.value = newTextValueChange
        } else {
            _textValueChange.value = ""
        }
    }

    /**
     * Set the text for siteID to search on TextField
     * @param siteId value change
     */
    fun onChangeValueSiteId(siteId: String) {
        _textSiteId.value = siteId
    }

    /**
     * Get sites to options for search
     */
    fun getSites() = viewModelScope.launch(Dispatchers.IO) {
        _sites.emit(Response.Loading)
        _sites.emit(sitesFacade.sitesUseCase())
    }
}
