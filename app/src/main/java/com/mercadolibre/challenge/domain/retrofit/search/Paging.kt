package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Paging(
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("primary_results")
    val primaryResults: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
)
