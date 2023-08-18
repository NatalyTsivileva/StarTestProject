package com.civileva.nata.cocktail.startestproject.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetNetworkModel(
	@SerialName("results")
	val planetData: List<Data>
) : ListNetworkModel() {

	@Serializable
	data class Data(
		val name: String = "",
		val diameter: Int = 0,
		val population: String = "",
		val url: String = ""
	)
}