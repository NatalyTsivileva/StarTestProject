package com.civileva.nata.cocktail.startestproject.presentation.ui.favorite

import androidx.lifecycle.ViewModel
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository

class FavoriteViewModel(
	private val repository: IStarWarsRepository,
) : ViewModel() {

/*	companion object FavoriteStarWarsViewModel: ViewModelProvider.Factory {
		override fun <T : ViewModel> create(modelClass: Class<T>): T {
			val module = NetworkModule()
			val client = module.provideClient()
			val service = module.provideRetrofit(client)
			val dispatcher = StarWarsDispatcher()
			return FavoriteViewModel(StarWarsRepository(service, dispatcher)) as T
		}
	}*/
}