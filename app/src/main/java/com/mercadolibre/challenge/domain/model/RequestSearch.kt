package com.mercadolibre.challenge.domain.model

class RequestSearch(builder: RequestBuilder) {

    val product: String
    private val anotherParameter: String?

    init {
        this.product = builder.product
        this.anotherParameter = builder.anotherParameter
    }

    override fun toString(): String {
        return "Request: $product - $anotherParameter"
    }

    class RequestBuilder(val product: String) {
        var anotherParameter: String? = null

        fun anotherParameter(anotherParameter: String?): RequestBuilder {
            this.anotherParameter = anotherParameter
            return this
        }

        fun build(): RequestSearch {
            return RequestSearch(this)
        }
    }
}