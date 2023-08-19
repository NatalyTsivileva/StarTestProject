package com.civileva.nata.cocktail.startestproject.data.model

data class Person(
	override val id: Int,
	override val name: String,
	val gender: GENDER,
	val starshipsCount: Int,
) : ListItem() {
	enum class GENDER {
		MALE, FEMALE, UNDEFINED
	}

	companion object {
		fun toGender(value: String): GENDER = when (value.uppercase()) {
			GENDER.MALE.name.uppercase() -> GENDER.MALE
			GENDER.FEMALE.name.uppercase() -> GENDER.FEMALE
			else -> GENDER.UNDEFINED
		}
	}
}