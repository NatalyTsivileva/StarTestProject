package com.civileva.nata.cocktail.startestproject.network.repository.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class StarWarsDispatcher : IDispatcher {
	override fun getUI(): CoroutineDispatcher = Dispatchers.Main

	override fun getIO(): CoroutineDispatcher = Dispatchers.IO

	override fun getDefault(): CoroutineDispatcher = Dispatchers.Default
}