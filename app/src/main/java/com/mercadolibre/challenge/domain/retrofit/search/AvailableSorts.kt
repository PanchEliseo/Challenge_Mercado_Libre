package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the AvailableSorts of search response
 */
data class AvailableSorts(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
)
