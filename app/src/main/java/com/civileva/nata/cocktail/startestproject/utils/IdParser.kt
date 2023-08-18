package com.civileva.nata.cocktail.startestproject.utils

object IdParser {
	fun parseId(url: String): Int {
		return url
			.split("/")
			.dropLast(1)
			.lastOrNull()
			?.toIntOrNull()
			?: -1
	}
}