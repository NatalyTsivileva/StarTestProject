package com.civileva.nata.cocktail.startestproject.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieNetworkModel(
	@SerialName("results")
	val movieData: List<Data>
) : ListNetworkModel() {


	@Serializable
	data class Data(
		@SerialName("episode_id")
		val id: Int = 0,
		val title: String = "",
		val director: String = "",
		val producer: String = "",

		@SerialName("characters")
		val persons: List<String> = listOf(),
		val planets: List<String> = listOf(),
		val starships: List<String> = listOf(),
	)
}