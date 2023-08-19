package com.civileva.nata.cocktail.startestproject.presentation.ui

import com.civileva.nata.cocktail.startestproject.data.model.EmptyItem
import com.civileva.nata.cocktail.startestproject.data.model.ListItem

sealed interface RequestState<T : ListItem>

object Loading : RequestState<EmptyItem>
class Success<T : ListItem>(val data: List<T>) : RequestState<T>
class Error<T : ListItem>(val message: String? = null) : RequestState<T>