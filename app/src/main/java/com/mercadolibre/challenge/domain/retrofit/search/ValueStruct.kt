package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class ValueStruct(
    @SerializedName("number")
    val number: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)
