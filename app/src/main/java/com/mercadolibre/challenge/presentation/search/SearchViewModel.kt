package com.mercadolibre.challenge.presentation.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(): ViewModel() {

    private var _textValueChange: MutableStateFlow<String> = MutableStateFlow("")
    val textValueChange = _textValueChange.asStateFlow()

    fun onChangeValueChange(newTextValueChange: String) {
        _textValueChange.value = newTextValueChange
    }

}