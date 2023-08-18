package com.civileva.nata.cocktail.startestproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class PersonEntity(
	@PrimaryKey
	val id: Int,
	val name: String,
	val isMaleGender: Boolean,
	val starshipCount: Int
)