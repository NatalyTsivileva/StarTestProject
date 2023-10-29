package com.civileva.nata.cocktail.startestproject.network.repository

import com.civileva.nata.cocktail.startestproject.data.model.*
import com.civileva.nata.cocktail.startestproject.db.StarWarsDB
import com.civileva.nata.cocktail.startestproject.network.api.StarWarsAPI
import com.civileva.nata.cocktail.startestproject.network.converter.MovieModelConverter
import com.civileva.nata.cocktail.startestproject.network.converter.PersonModelConverter
import com.civileva.nata.cocktail.startestproject.network.converter.PlanetModelConverter
import com.civileva.nata.cocktail.startestproject.network.converter.StarshipModelConverter
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.IDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class StarWarsRepository(
	private val api: StarWarsAPI,
	private val dispatcher: IDispatcher,
	private val database: StarWarsDB? = null
) : IStarWarsRepository {

	override suspend fun getPerson(name: String?, updated: Boolean): List<Person> =
		withContext(dispatcher.getIO()) {
			//TODO:добавить кэширование  - должны обновить при Swipe Refresh
			val networkModel = api.getPersons(name)
			val entityList = networkModel.personData.map { PersonModelConverter.toPersonEntity(it) }
			entityList.map { PersonModelConverter.toPerson(it) }
		}

	override suspend fun getStarship(name: String?, updated: Boolean): List<Starship> =
		withContext(dispatcher.getIO()) {
			val networkModel = api.getStarships(name)
			val entityList =
				networkModel.starshipData.map { StarshipModelConverter.toStarshipEntity(it) }
			//TODO:добавить кэширование  - должны обновить при Swipe Refresh
			entityList.map { StarshipModelConverter.toStarship(it) }
		}

	override suspend fun getPlanet(name: String?, updated: Boolean): List<Planet> =
		withContext(dispatcher.getIO()) {
			val networkModel = api.getPlanets(name)
			val entityList = networkModel.planetData.map { PlanetModelConverter.toPlanetEntity(it) }
			//TODO:добавить кэширование - должны обновить при Swipe Refresh
			entityList.map { PlanetModelConverter.toPlanet(it) }
		}

	override suspend fun getAllMovie(updated: Boolean): List<Movie> =
		withContext(dispatcher.getIO()) {
			val networkModel = api.getFilms()
			val entity = networkModel.movieData.map { MovieModelConverter.toMovieEntity(it) }
			//TODO: добавить кэширование.
			// Добавить данные в таблицу Movie, добавить данные
			// в аггрегатные таблицы PerdonMovieAggr, PlanetMovieAggr, StarshipMovieAggr
			entity.map { MovieModelConverter.toMovie(it) }
		}

	override fun searchItems(text: String, updated: Boolean): Flow<List<ListItem>> = flow {
		val list = getPerson(text, updated) + getPlanet(text, updated) + getStarship(text, updated)
		emit(list)
	}
}