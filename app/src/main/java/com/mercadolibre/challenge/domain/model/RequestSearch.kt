package com.mercadolibre.challenge.domain.model

/**
 * Represent request in Search
 * @param builder Request builder
 */
class RequestSearch(builder: RequestBuilder) {

    /**
     * Product for search
     */
    val product: String
    val siteId: String

    /**
     * Initialize values
     */
    init {
        this.product = builder.product
        this.siteId = builder.siteId
    }

    override fun toString(): String {
        return "Request: $product - $siteId"
    }

    /**
     * Represent builder of Search
     * @param product The product for Search
     */
    class RequestBuilder(val product: String) {

        /**
         * Another param
         */
        var siteId: String = ""

        /**
         * Set another param
         */
        fun siteId(anotherParameter: String): RequestBuilder {
            this.siteId = anotherParameter
            return this
        }

        /**
         * Build method
         */
        fun build(): RequestSearch {
            return RequestSearch(this)
        }
    }
}