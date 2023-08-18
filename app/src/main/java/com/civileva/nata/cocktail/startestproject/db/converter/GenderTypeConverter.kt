package com.civileva.nata.cocktail.startestproject.db.converter

import androidx.room.TypeConverter
import com.civileva.nata.cocktail.startestproject.data.model.Person

class GenderTypeConverter {
	@TypeConverter
	fun toGender(value: String): Person.GENDER = Person.toGender(value)

	@TypeConverter
	fun fromGender(gender: Person.GENDER): String {
		return gender.name.uppercase()
	}
}