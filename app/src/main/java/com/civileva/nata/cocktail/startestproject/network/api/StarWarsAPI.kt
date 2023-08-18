package com.civileva.nata.cocktail.startestproject.network.api

import com.civileva.nata.cocktail.startestproject.network.model.MovieNetworkModel
import com.civileva.nata.cocktail.startestproject.network.model.PersonNetworkModel
import com.civileva.nata.cocktail.startestproject.network.model.PlanetNetworkModel
import com.civileva.nata.cocktail.startestproject.network.model.StarhipNetworkModel
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsAPI {
	@GET("people")
	suspend fun getPersons(@Query("search") name: String): PersonNetworkModel

	@GET("starships")
	suspend fun getStarships(@Query("search") name: String): StarhipNetworkModel

	@GET("planets")
	suspend fun getPlanets(@Query("search") name: String): PlanetNetworkModel

	@GET("films")
	suspend fun getFilms(): MovieNetworkModel

}