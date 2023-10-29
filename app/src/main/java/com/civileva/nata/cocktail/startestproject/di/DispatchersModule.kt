package com.civileva.nata.cocktail.startestproject.di

import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.IDispatcher
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.StarWarsDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

	@Provides
	@Singleton
	fun bindDispatcher(): IDispatcher = StarWarsDispatcher()
}