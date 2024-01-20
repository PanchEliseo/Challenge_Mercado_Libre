package com.mercadolibre.challenge.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(): ViewModel() {

    private var _textValueChange = MutableLiveData<String>()
    val textValueChange: LiveData<String> = _textValueChange

    fun onChangeValueChange(newTextValueChange: String) {
        _textValueChange.value = newTextValueChange
    }

}