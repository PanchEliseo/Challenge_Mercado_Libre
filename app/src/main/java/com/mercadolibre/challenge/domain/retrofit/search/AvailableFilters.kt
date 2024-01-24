package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the AvailableFilters of search response
 */
data class AvailableFilters(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("values")
    val values: List<ValuesFilters>,
)
