package com.civileva.nata.cocktail.startestproject.viewmodel

import com.civileva.nata.cocktail.startestproject.data.model.*
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestRepository : IStarWarsRepository {
	private val items = MutableSharedFlow<List<ListItem>>()
	suspend fun emit(value: List<ListItem>) = items.emit(value)


	override suspend fun getAllMovie(): List<Movie> {
		return movieTestData
	}


	override suspend fun getPerson(name: String?): List<Person> {
		return personTestData
	}

	override suspend fun getStarship(name: String?): List<Starship> {
		return starshipTestData
	}

	override suspend fun getPlanet(name: String?): List<Planet> {
		return planetTestData
	}

	override fun searchItems(text: String): Flow<List<ListItem>> {
		return items
	}


	companion object {
		val planetTestData = (0 until 10).map {
			Planet(
				id = it,
				name = "planet${it}",
				diameter = 100,
				populationInfo = "population${it}"
			)
		}
		val personTestData = (10 until 18).map {
			Person(
				id = it,
				name = "person${it}",
				gender = Person.GENDER.MALE,
				starshipsCount = it
			)
		}
		val starshipTestData = (18 until 25).map {
			Starship(
				id = it,
				name = "starship${it}",
				model = "starship${it}",
				manufacturer = "starship${it}",
				passengersInfo = "passenger${it}"
			)
		}
		val movieTestData = (0 until 16).map {
			Movie(
				id = it,
				name = "movie$it",
				director = "director$it",
				producer = "producer$it"
			)
		}
	}
}