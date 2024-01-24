package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the PdpTracking of search response
 */
data class PdpTracking(
    @SerializedName("group")
    val group: Boolean? = null,
    @SerializedName("product_info")
    val productInfo: List<ProductInfo>
)
