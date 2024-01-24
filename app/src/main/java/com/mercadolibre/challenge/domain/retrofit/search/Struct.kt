package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the Struct of search response
 */
data class Struct(
    @SerializedName("number")
    val number: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)
