package com.civileva.nata.cocktail.startestproject.network.model

import kotlinx.serialization.Serializable

@Serializable
abstract class ListNetworkModel(
	val count: Int? = 0,
	val next: String? = "",
	val previous: String? = ""
)