package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Sheller(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("nickname")
    val nickname: String? = null,
)
