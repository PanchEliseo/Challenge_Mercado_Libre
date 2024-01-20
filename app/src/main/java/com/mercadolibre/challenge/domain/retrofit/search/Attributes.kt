package com.mercadolibre.challenge.domain.retrofit.search

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value_id")
    val valueId: String? = null,
    @SerializedName("value_name")
    val valueName: String? = null,
    @SerializedName("attribute_group_id")
    val attributeGroupId: String? = null,
    @SerializedName("attribute_group_name")
    val attributeGroupName: String? = null,
    @SerializedName("value_struct")
    val valueStruct: ValueStruct? = null,
    @SerializedName("values")
    val values: List<Value>,
    @SerializedName("source")
    val source: Long? = null,
    @SerializedName("value_type")
    val valueType: String? = null,
)
