package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the ProductInfo of search response
 */
data class ProductInfo(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("score")
    val score: Int? = null,
    @SerializedName("status")
    val status: String? = null,
)