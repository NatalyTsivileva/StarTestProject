package com.civileva.nata.cocktail.startestproject.presentation.ui.usecase

import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class SearchInfoUseCase : SearchUseCase {

	override suspend fun searchPersonPlanetStarship(
		text: String,
		repository: IStarWarsRepository
	): List<ListItem> = coroutineScope {
		val person = async { repository.getPerson(text) }
		val planet = async { repository.getPlanet(text) }
		val starships = async { repository.getStarship(text) }

		person.await() + planet.await() + starships.await()
	}
}