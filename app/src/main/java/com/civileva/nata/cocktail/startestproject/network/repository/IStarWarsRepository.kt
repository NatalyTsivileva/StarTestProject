package com.civileva.nata.cocktail.startestproject.network.repository

import com.civileva.nata.cocktail.startestproject.data.model.*
import kotlinx.coroutines.flow.Flow


interface IStarWarsRepository {

	fun searchItems(text: String, updated:Boolean): Flow<List<ListItem>>

	suspend fun getAllMovie(updated:Boolean): List<Movie>

	suspend fun getPerson(name: String?, updated:Boolean): List<Person>
	suspend fun getStarship(name: String?, updated:Boolean): List<Starship>
	suspend fun getPlanet(name: String?, updated:Boolean): List<Planet>
}