package com.civileva.nata.cocktail.startestproject.presentation.ui.favorite

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.civileva.nata.cocktail.startestproject.db.StarWarsDB
import com.civileva.nata.cocktail.startestproject.network.NetworkModule
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.StarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.StarWarsDispatcher

class FavoriteViewModel(
	private val repository: IStarWarsRepository,
) : ViewModel() {

	companion object FavoriteStarWarsViewModel: ViewModelProvider.Factory {
		override fun <T : ViewModel> create(modelClass: Class<T>): T {
			val module = NetworkModule()
			val client = module.provideClient()
			val service = module.provideRetrofit(client)
			val dispatcher = StarWarsDispatcher()
			return FavoriteViewModel(StarWarsRepository(service, dispatcher)) as T
		}
	}
}