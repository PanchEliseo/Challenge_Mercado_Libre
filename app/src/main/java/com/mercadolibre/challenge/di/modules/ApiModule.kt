package com.mercadolibre.challenge.di.modules

import com.mercadolibre.challenge.domain.repository.SearchRepositoryImp
import com.mercadolibre.challenge.domain.retrofit.SearchService
import com.mercadolibre.challenge.domain.use_case.search.Search
import com.mercadolibre.challenge.domain.use_case.search.SearchUseCase
import com.mercadolibre.challenge.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): SearchService = retrofit.create(SearchService::class.java)

    @Singleton
    @Provides
    fun provideSearchRepository(service: SearchService) = SearchRepositoryImp(service)

    @Singleton
    @Provides
    fun provideSearchUseCase(repository: SearchRepositoryImp) = SearchUseCase(
        search = Search(repository)
    )
}