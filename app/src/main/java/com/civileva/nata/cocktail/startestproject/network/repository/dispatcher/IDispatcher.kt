package com.civileva.nata.cocktail.startestproject.network.repository.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface IDispatcher {
	fun getUI(): CoroutineDispatcher
	fun getIO(): CoroutineDispatcher
	fun getDefault(): CoroutineDispatcher
}