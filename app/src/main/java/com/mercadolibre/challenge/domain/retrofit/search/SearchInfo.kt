package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName
import com.mercadolibre.challenge.utils.SEARCH_TEXT

class SearchInfo(
    @SerializedName(SEARCH_TEXT) val search: String
)