package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Values(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("path_from_root")
    val pathFromRoot: List<PathFromRoot>,
)
