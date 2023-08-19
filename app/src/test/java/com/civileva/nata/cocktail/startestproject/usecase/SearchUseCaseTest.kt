package com.civileva.nata.cocktail.startestproject.usecase

import com.civileva.nata.cocktail.startestproject.network.NetworkModule
import com.civileva.nata.cocktail.startestproject.network.repository.StarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.TestStarWarsDispatcher
import com.civileva.nata.cocktail.startestproject.presentation.ui.Success
import com.civileva.nata.cocktail.startestproject.presentation.ui.search.SearchViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class SearchUseCaseTest {
	@Test
	fun `when request Search-while Success-should return list with items`() = runTest {

		val module = NetworkModule()
		val client = module.provideClient()
		val service = module.provideRetrofit(client)
		val dispatcher = TestStarWarsDispatcher()
		val useCase = SearchSuccessUseCase()
		val repository = StarWarsRepository(service, dispatcher)

		val viewModel = SearchViewModel(repository, dispatcher, useCase)
		Assert.assertEquals(Success::class, viewModel.searched.value::class)
	}

	@Test
	fun `when-while-should`() {

	}
}