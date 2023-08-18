package com.civileva.nata.cocktail.startestproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Starship")
data class StarshipEntity(
	@PrimaryKey
	val id: Int,
	val name: String,
	val model: String,
	val manufacture: String,
	val passenger: String
)