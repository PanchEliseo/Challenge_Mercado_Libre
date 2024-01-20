package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("store_pick_up")
    val storePickUp: Boolean? = null,
    @SerializedName("free_shipping")
    val freeShipping: Boolean? = false,
    @SerializedName("logistic_type")
    val logisticType: String? = null,
    @SerializedName("mode")
    val mode: String? = null,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("benefits")
    val benefits: String? = null,
    @SerializedName("promise")
    val promise: String? = null
)
