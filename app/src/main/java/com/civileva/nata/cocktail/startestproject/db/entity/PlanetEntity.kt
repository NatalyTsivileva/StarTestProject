package com.civileva.nata.cocktail.startestproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Planet")
data class PlanetEntity(
	@PrimaryKey
	val id: Int,
	val name: String,
	val diameter: Int,
	val population: String
)