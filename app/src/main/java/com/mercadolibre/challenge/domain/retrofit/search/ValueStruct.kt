package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the ValueStruct of search response
 */
data class ValueStruct(
    @SerializedName("number")
    val number: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)
