package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the PathFromRoot of search response
 */
data class PathFromRoot(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
)
