package com.civileva.nata.cocktail.startestproject.data.model

data class Movie(
	override val id: Int,
	override val name: String,
	val director: String,
	val producer: String
) : ListItem()