package com.civileva.nata.cocktail.startestproject.usecase

import com.civileva.nata.cocktail.startestproject.data.model.ListItem
import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.data.model.Planet
import com.civileva.nata.cocktail.startestproject.data.model.Starship
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import com.civileva.nata.cocktail.startestproject.presentation.ui.usecase.SearchUseCase

class SearchSuccessUseCase : SearchUseCase {
	override suspend fun searchPersonPlanetStarship(
		text: String,
		repository: IStarWarsRepository
	): List<ListItem> {
		return testSearchCaseList
	}

	companion object {
		val testSearchCaseList = listOf(
			Planet(id = 1, name = "planet1", diameter = 1000, populationInfo = "planet1population"),
			Person(id = 2, name = "person1", gender = Person.GENDER.MALE, starshipsCount = 3),
			Starship(
				id = 3,
				name = "starship1",
				model = "starship1",
				manufacturer = "manufacturer",
				passengersInfo = "starship1"
			)
		)
	}
}