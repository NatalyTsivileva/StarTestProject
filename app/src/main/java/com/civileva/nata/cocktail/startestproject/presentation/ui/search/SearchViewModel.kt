package com.civileva.nata.cocktail.startestproject.presentation.ui.search

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
import com.civileva.nata.cocktail.startestproject.presentation.ui.usecase.SearchInfoUseCase
import com.civileva.nata.cocktail.startestproject.presentation.ui.usecase.SearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
	private val repository: IStarWarsRepository,
	private val dispatcher: IDispatcher,
	private val searchUseCase: SearchUseCase
) : ViewModel() {


	private val _searched = MutableStateFlow<RequestState<*>>(Loading)
	val searched: StateFlow<RequestState<*>> = _searched

	//fun search(text: String) {
	/*viewModelScope.launch(dispatcher.getDefault()) {
		val items = mutableListOf<ListItem>()
		items += repository.findPerson(text)
		items += repository.findPlanet(text)
		items += repository.findStarship(text)

		_searched.value = Success(items)
	}*/
	//}//

	fun search(text: String) {
		viewModelScope.launch(dispatcher.getDefault()) {
			val result = searchUseCase.searchPersonPlanetStarship(text, repository)
			_searched.value = Success(result)
		}
	}


	companion object SearchViewModelProvider : ViewModelProvider.Factory {
		override fun <T : ViewModel> create(modelClass: Class<T>): T {
			val module = NetworkModule()
			val client = module.provideClient()
			val service = module.provideRetrofit(client)
			val dispatcher = StarWarsDispatcher()
			val useCase = SearchInfoUseCase()

			return SearchViewModel(
				StarWarsRepository(service, dispatcher),
				dispatcher,
				useCase
			) as T
		}
	}
}