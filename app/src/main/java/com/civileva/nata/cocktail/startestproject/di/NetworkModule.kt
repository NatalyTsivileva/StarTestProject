package com.civileva.nata.cocktail.startestproject.di

import com.civileva.nata.cocktail.startestproject.BuildConfig
import com.civileva.nata.cocktail.startestproject.network.api.StarWarsAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideClient(): OkHttpClient {
		val interceptor = HttpLoggingInterceptor().apply {
			setLevel(HttpLoggingInterceptor.Level.BASIC)
		}
		return OkHttpClient.Builder().addInterceptor(interceptor).build()
	}


	@Provides
	@Singleton
	fun provideRetrofit(client: OkHttpClient): StarWarsAPI {
		val json = Json { ignoreUnknownKeys = true }
		val contentType = "application/json".toMediaType()
		val retrofit = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(json.asConverterFactory(contentType))
			.client(client)
			.build()
		return retrofit.create(StarWarsAPI::class.java)
	}
}