package com.civileva.nata.cocktail.startestproject.presentation.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.civileva.nata.cocktail.startestproject.network.NetworkModule
import com.civileva.nata.cocktail.startestproject.network.repository.IStarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.StarWarsRepository
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.IDispatcher
import com.civileva.nata.cocktail.startestproject.network.repository.dispatcher.StarWarsDispatcher
import com.civileva.nata.cocktail.startestproject.presentation.ui.Loading
import com.civileva.nata.cocktail.startestproject.presentation.ui.RequestState
import com.civileva.nata.cocktail.startestproject.presentation.ui.Success
import com.civileva.nata.cocktail.startestproject.presentation.ui.Undefined
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
	private val repository: IStarWarsRepository,
	private val dispatcher: IDispatcher
) : ViewModel() {


	private val _searched = MutableStateFlow<RequestState<*>>(Undefined)
	val searched: StateFlow<RequestState<*>> = _searched


	fun search(text: String, update: Boolean = false) {
		_searched.value = Loading
		viewModelScope.launch(dispatcher.getDefault()) {
			try {
				repository.searchItems(text, update).collect {
					_searched.value = Success(it)
				}
			} catch (e: Exception) {
				_searched.value =
					com.civileva.nata.cocktail.startestproject.presentation.ui.Error(e.message)
				Log.d("ERR",e.message?:"")
			}
		}
	}


	companion object SearchViewModelProvider : ViewModelProvider.Factory {
		override fun <T : ViewModel> create(modelClass: Class<T>): T {
			val module = NetworkModule()
			val client = module.provideClient()
			val service = module.provideRetrofit(client)
			val dispatcher = StarWarsDispatcher()

			return SearchViewModel(
				StarWarsRepository(service, dispatcher),
				dispatcher
			) as T
		}
	}
}