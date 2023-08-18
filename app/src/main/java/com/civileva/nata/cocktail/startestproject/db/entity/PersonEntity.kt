package com.civileva.nata.cocktail.startestproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.db.converter.GenderTypeConverter

@Entity(tableName = "Person")
@TypeConverters(GenderTypeConverter::class)
data class PersonEntity(
	@PrimaryKey
	val id: Int,
	val name: String,
	val gender: Person.GENDER,
	val starshipCount: Int
)