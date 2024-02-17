package com.mercadolibre.challenge.domain.retrofit.sites

import com.google.gson.annotations.SerializedName

/**
 * Data class for site response
 */
data class ResponseSites(
    @SerializedName("default_currency_id")
    val defaultCurrencyId: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
)
