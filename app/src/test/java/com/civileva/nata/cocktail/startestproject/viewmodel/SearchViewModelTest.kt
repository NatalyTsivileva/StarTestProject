package com.civileva.nata.cocktail.startestproject.viewmodel

import com.civileva.nata.cocktail.startestproject.data.model.*
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.IDispatcher
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.TestStarWarsDispatcher
import com.civileva.nata.cocktail.startestproject.presentation.ui.Loading
import com.civileva.nata.cocktail.startestproject.presentation.ui.Success
import com.civileva.nata.cocktail.startestproject.presentation.ui.search.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class SearchViewModelTest {
	@OptIn(ExperimentalCoroutinesApi::class)
	@Test
	fun `when`() = runTest {
		val dispatcher = TestStarWarsDispatcher()
		val repository = TestRepository()
		val viewModel = SearchViewModel(repository, dispatcher)

		val emittedData = emitTestData(repository,dispatcher, backgroundScope, movieTestData)
		viewModel.search("")
 		Assert.assertEquals(movieTestData, emittedData)

		println("TEST DATA=${viewModel.searched.value}")


	}
	suspend fun emitTestData(
		repository: TestRepository,
		dispatcher: IDispatcher,
		scope: CoroutineScope,
		newItems: List<ListItem>
	): List<ListItem> {

		var resultList = listOf<ListItem>()

		scope.launch(dispatcher.getDefault()) {
			repository.searchItems("").collect {
				resultList = it
			}
		}

		repository.emit(newItems)

		return resultList
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