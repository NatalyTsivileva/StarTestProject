package com.civileva.nata.cocktail.startestproject.viewmodel

import com.civileva.nata.cocktail.startestproject.network.NetworkModule
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.TestStarWarsDispatcher
import com.civileva.nata.cocktail.startestproject.presentation.ui.Loading
import com.civileva.nata.cocktail.startestproject.presentation.ui.Success
import com.civileva.nata.cocktail.startestproject.presentation.ui.search.SearchViewModel
import com.civileva.nata.cocktail.startestproject.usecase.SearchSuccessUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class SearchViewModelTest {
	@Test
	fun t() = runTest {
		val module = NetworkModule()
		val client = module.provideClient()
		val service = module.provideRetrofit(client)
		val dispatcher = TestStarWarsDispatcher()
		val useCase = SearchSuccessUseCase()
		val repository = TestRepository()
		val viewModel = SearchViewModel(repository, dispatcher, useCase)


		Assert.assertEquals(Loading::class, viewModel.searched.value::class)
		repository.emit(TestRepository.movieTestData)


		Assert.assertEquals(Success::class, viewModel.searched.value::class)
		repository.searchItems("")
		Assert.assertEquals(
			TestRepository.movieTestData,
			(viewModel.searched.value as? Success)?.data
		)

	}
}