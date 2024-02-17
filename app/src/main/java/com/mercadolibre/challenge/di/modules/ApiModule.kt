package com.mercadolibre.challenge.di.modules

import com.mercadolibre.challenge.data.repository.search.SearchRepositoryImp
import com.mercadolibre.challenge.data.repository.sites.SitesRepositoryImp
import com.mercadolibre.challenge.domain.retrofit.SearchService
import com.mercadolibre.challenge.useCase.search.SearchUseCase
import com.mercadolibre.challenge.useCase.search.SearchFacade
import com.mercadolibre.challenge.useCase.sites.SitesFacade
import com.mercadolibre.challenge.useCase.sites.SitesUseCase
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

/**
 * ApiModule with initialize Retrofit. Providers for ApiServices, Repositories and UseCases
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    /**
     * Provider for loggingInterceptor
     */
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    /**
     * Provider for HttpClient
     * @param httpLoggingInterceptor The http logging interceptor
     */
    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    /**
     * Provider for build retrofit
     * @param okHttpClient The http client
     */
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    /**
     * Provider for search service with retrofit
     * @param retrofit The retrofit instance
     */
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): SearchService = retrofit.create(SearchService::class.java)

    /**
     * Provider for repository
     * @param service The service instance
     */
    @Singleton
    @Provides
    fun provideSearchRepository(service: SearchService) = SearchRepositoryImp(service)

    @Singleton
    @Provides
    fun provideSitesRepository(service: SearchService) = SitesRepositoryImp(service)

    /**
     * Provider for use case
     * @param repository The repository search instance
     */
    @Singleton
    @Provides
    fun provideSearchUseCase(repository: SearchRepositoryImp) = SearchFacade(
        searchUseCase = SearchUseCase(repository)
    )

    @Singleton
    @Provides
    fun provideSitesUseCase(repositoryImp: SitesRepositoryImp) = SitesFacade(
        sitesUseCase = SitesUseCase(repositoryImp)
    )
}
