package com.civileva.nata.cocktail.startestproject.network.repository

import com.civileva.nata.cocktail.startestproject.data.model.*
import kotlinx.coroutines.flow.Flow


interface IStarWarsRepository {
	suspend fun getPerson(name: String?): List<Person>
	suspend fun getStarship(name: String?): List<Starship>
	suspend fun getPlanet(name: String?): List<Planet>

	suspend fun getAllMovie(): List<Movie>

	fun searchItems(text: String): Flow<List<ListItem>>
}