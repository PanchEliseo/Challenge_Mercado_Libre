package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("struct")
    val struct: Struct? = null,
    @SerializedName("source")
    val source: Long? = null
)
