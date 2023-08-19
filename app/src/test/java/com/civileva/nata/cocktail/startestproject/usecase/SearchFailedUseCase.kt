package com.civileva.nata.cocktail.startestproject.usecase

import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import com.civileva.nata.cocktail.startestproject.presentation.ui.usecase.SearchUseCase

class SearchFailedUseCase : SearchUseCase {
	override suspend fun searchPersonPlanetStarship(
		text: String,
		repository: IStarWarsRepository
	): List<ListItem> {
		throw NullPointerException()
	}
}