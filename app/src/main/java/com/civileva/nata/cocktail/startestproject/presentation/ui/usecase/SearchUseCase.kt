package com.civileva.nata.cocktail.startestproject.presentation.ui.usecase

import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository

interface SearchUseCase {

	suspend fun searchPersonPlanetStarship(
		text: String,
		repository: IStarWarsRepository
	): List<ListItem>
}