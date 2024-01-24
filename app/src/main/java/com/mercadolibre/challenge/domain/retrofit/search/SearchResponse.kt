package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

/**
 * Represent the SearchResponse class
 */
data class SearchResponse(
    @SerializedName("site_id")
    val siteId: String? = null,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String? = null,
    @SerializedName("query")
    val query: String? = null,
    @SerializedName("paging")
    val paging: Paging? = null,
    @SerializedName("results")
    val results: List<Results>? = null,
    @SerializedName("sort")
    val sort: Sort? = null,
    @SerializedName("available_sorts")
    val availableSorts: List<AvailableSorts>? = null,
    @SerializedName("filters")
    val filters: List<Filters>? = null,
    @SerializedName("available_filters")
    val availableFilters: List<AvailableFilters>? = null,
    @SerializedName("pdp_tracking")
    val pdpTracking: PdpTracking? = null,
)