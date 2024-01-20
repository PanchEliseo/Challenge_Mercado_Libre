package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("condition")
    val condition: String? = null,
    @SerializedName("thumbnail_id")
    val thumbnailId: String? = null,
    @SerializedName("catalog_product_id")
    val catalogProductId: String? = null,
    @SerializedName("listing_type_id")
    val listingTypeId: String? = null,
    @SerializedName("permalink")
    val permalink: String? = null,
    @SerializedName("buying_mode")
    val buyingMode: String? = null,
    @SerializedName("site_id")
    val siteId: String? = null,
    @SerializedName("category_id")
    val categoryId: String? = null,
    @SerializedName("domain_id")
    val domainId: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String = "",
    @SerializedName("currency_id")
    val currencyId: String = "",
    @SerializedName("order_backend")
    val orderBackend: Int? = null,
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("original_price")
    val originalPrice: Double? = null,
    @SerializedName("sale_price")
    val salePrice: String? = null,
    @SerializedName("available_quantity")
    val availableQuantity: Int? = null,
    @SerializedName("official_store_id")
    val officialStoreId: Int? = null,
    @SerializedName("official_store_name")
    val officialStoreName: String? = null,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean? = null,
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean? = null,
    @SerializedName("shipping")
    val shipping: Shipping? = null,
    @SerializedName("stop_time")
    val stopTime: String? = null,
    @SerializedName("seller")
    val seller: Sheller? = null,
    @SerializedName("attributes")
    val attributes: List<Attributes>? = null,
    @SerializedName("installments")
    val installments: Installments? = null,
    @SerializedName("winner_item_id")
    val winnerItemId: String? = null,
    @SerializedName("catalog_listing")
    val catalogListing: Boolean? = null,
    @SerializedName("discounts")
    val discounts: String? = null,
    @SerializedName("promotions")
    val promotions: List<String>? = null,
    @SerializedName("inventory_id")
    val inventoryId: String? = null

)