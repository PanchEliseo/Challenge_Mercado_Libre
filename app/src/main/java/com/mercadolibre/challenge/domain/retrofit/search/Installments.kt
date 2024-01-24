package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the Installments of search response
 */
data class Installments(
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("rate")
    val rate: Double? = null,
    @SerializedName("currency_id")
    val currencyId: String? = null,
)
