package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the Filters of search response
 */
data class Filters(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("values")
    val values: List<Values>,
)
