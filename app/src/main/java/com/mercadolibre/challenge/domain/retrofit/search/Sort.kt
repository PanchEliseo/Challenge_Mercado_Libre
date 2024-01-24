package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the Sort of search response
 */
data class Sort(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
)
