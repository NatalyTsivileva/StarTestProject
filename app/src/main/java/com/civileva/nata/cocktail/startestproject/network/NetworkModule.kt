package com.civileva.nata.cocktail.startestproject.network

import com.civileva.nata.cocktail.startestproject.BuildConfig
import com.civileva.nata.cocktail.startestproject.network.api.StarWarsAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.modules.EmptySerializersModule
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class NetworkModule {

	fun provideClient(): OkHttpClient {
		val interceptor = HttpLoggingInterceptor().apply {
			setLevel(HttpLoggingInterceptor.Level.BASIC)
		}
		return OkHttpClient.Builder().addInterceptor(interceptor).build()
	}

	private val json = Json {
		ignoreUnknownKeys = true
	}

	fun provideRetrofit(client: OkHttpClient): StarWarsAPI {
		val contentType = "application/json".toMediaType()
		val retrofit = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(json.asConverterFactory(contentType))
			.client(client)
			.build()
		return retrofit.create(StarWarsAPI::class.java)
	}
}