package com.civileva.nata.cocktail.startestproject.network

import com.civileva.nata.cocktail.startestproject.BuildConfig
import com.civileva.nata.cocktail.startestproject.network.api.StarWarsAPI
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

	fun provideRetrofit(client: OkHttpClient): StarWarsAPI {
		val retrofit = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.client(client)
			.build()

		return retrofit.create(StarWarsAPI::class.java)
	}
}