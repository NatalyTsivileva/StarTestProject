package com.civileva.nata.cocktail.startestproject.viewmodel

import com.civileva.nata.cocktail.startestproject.data.model.*
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestRepository : IStarWarsRepository {
	private val items = MutableSharedFlow<List<ListItem>>()
	suspend fun emit(value: List<ListItem>) = items.emit(value)


	override suspend fun getAllMovie(): List<Movie> {
		return emptyList()
	}


	override suspend fun getPerson(name: String?): List<Person> {
		return emptyList()
	}

	override suspend fun getStarship(name: String?): List<Starship> {
		return emptyList()
	}

	override suspend fun getPlanet(name: String?): List<Planet> {
		return emptyList()
	}

	override fun searchItems(text: String): Flow<List<ListItem>> {
		return items
	}



}