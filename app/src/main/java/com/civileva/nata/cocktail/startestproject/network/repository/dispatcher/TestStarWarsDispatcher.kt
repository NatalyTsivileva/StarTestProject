package com.civileva.nata.cocktail.startestproject.network.repository.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestStarWarsDispatcher : IDispatcher {
	@OptIn(ExperimentalCoroutinesApi::class)
	override fun getUI(): CoroutineDispatcher = UnconfinedTestDispatcher()

	@OptIn(ExperimentalCoroutinesApi::class)
	override fun getIO(): CoroutineDispatcher = UnconfinedTestDispatcher()

	@OptIn(ExperimentalCoroutinesApi::class)
	override fun getDefault(): CoroutineDispatcher = UnconfinedTestDispatcher()
}