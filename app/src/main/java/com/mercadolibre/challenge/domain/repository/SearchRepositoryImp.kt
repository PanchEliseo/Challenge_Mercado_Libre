package com.mercadolibre.challenge.domain.repository

import com.mercadolibre.challenge.domain.model.Response
import com.mercadolibre.challenge.domain.retrofit.search.SearchResponse
import com.mercadolibre.challenge.domain.retrofit.SearchService
import java.lang.Exception

class SearchRepositoryImp(private val service: SearchService): SearchRepository {
    override suspend fun search(product: String): Response<SearchResponse> {
        Response.Loading
        return try {
            val result = service.search(product)
            Response.Success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}