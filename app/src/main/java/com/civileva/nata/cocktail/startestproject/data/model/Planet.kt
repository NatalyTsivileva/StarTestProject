package com.civileva.nata.cocktail.startestproject.data.model

data class Planet(
	override val id: Int,
	override val name: String,
	val diameter: Int,
	val populationInfo: String
) : ListItem()