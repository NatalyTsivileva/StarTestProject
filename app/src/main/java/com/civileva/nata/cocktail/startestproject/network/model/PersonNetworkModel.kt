package com.civileva.nata.cocktail.startestproject.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonNetworkModel(
	@SerialName("results")
	val personData: List<Data> = emptyList()
) : ListNetworkModel() {

	@Serializable
	data class Data(
		@SerialName("name")
		val name: String = "",
		@SerialName("gender")
		val gender: String = "",
		@SerialName("starships")
		val starships: List<String> = listOf(),
		@SerialName("url")
		val url: String = ""
	)
}