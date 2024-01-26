package com.mercadolibre.challenge.presentation.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * [SearchViewModel] holds information about screen for search
 */
@HiltViewModel
class SearchViewModel @Inject constructor(): ViewModel() {

    /**
     * Product state for search
     */
    private var _textValueChange: MutableStateFlow<String> = MutableStateFlow("")
    val textValueChange = _textValueChange.asStateFlow()

    /**
     * set the text for product to search on TextField
     * @param newTextValueChange value change
     */
    fun onChangeValueChange(newTextValueChange: String) {
        if (newTextValueChange.matches(Regex("^[a-zA-Z0-9_][a-zA-Z0-9_ ]*[a-zA-Z0-9_]*$"))) {
            _textValueChange.value = newTextValueChange
        } else {
            _textValueChange.value = ""
        }
    }

}