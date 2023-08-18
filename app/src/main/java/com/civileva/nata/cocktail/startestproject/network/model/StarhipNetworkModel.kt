package com.civileva.nata.cocktail.startestproject.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class StarhipNetworkModel(
	@SerialName("results")
	val starshipData: List<Data>
) : ListNetworkModel() {


	@Serializable
	data class Data(
		val name: String = "",
		val model: String = "",
		val manufacturer: String = "",
		val passengers: String = "",
		val url: String = ""
	)
}