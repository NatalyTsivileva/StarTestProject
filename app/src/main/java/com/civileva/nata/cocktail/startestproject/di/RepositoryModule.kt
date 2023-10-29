package com.civileva.nata.cocktail.startestproject.di

import com.civileva.nata.cocktail.startestproject.db.StarWarsDB
import com.civileva.nata.cocktail.startestproject.network.api.StarWarsAPI
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.StarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.IDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	@Singleton
	fun provideRepository(
		api: StarWarsAPI,
		dispatcher: IDispatcher,
		db: StarWarsDB
	): IStarWarsRepository = StarWarsRepository(api, dispatcher, db)


}