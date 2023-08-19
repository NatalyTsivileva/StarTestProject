package com.civileva.nata.cocktail.startestproject.data.model

data class Starship(
	override val id: Int,
	override val name: String,
	val model: String,
	val manufacturer: String,
	val passengersInfo: String
) : ListItem()