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
    private val anotherParameter: String?

    /**
     * Initialize values
     */
    init {
        this.product = builder.product
        this.anotherParameter = builder.anotherParameter
    }

    override fun toString(): String {
        return "Request: $product - $anotherParameter"
    }

    /**
     * Represent builder of Search
     * @param product The product for Search
     */
    class RequestBuilder(val product: String) {

        /**
         * Another param
         */
        var anotherParameter: String? = null

        /**
         * Set another param
         */
        fun anotherParameter(anotherParameter: String?): RequestBuilder {
            this.anotherParameter = anotherParameter
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