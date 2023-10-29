package com.civileva.nata.cocktail.startestproject.network.repository.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestStarWarsDispatcher(
	private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : IDispatcher {

	override fun getUI(): CoroutineDispatcher = dispatcher

	override fun getIO(): CoroutineDispatcher = dispatcher

	override fun getDefault(): CoroutineDispatcher = dispatcher
}