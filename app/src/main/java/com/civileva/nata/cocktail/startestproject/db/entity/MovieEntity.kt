package com.civileva.nata.cocktail.startestproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class MovieEntity(
	@PrimaryKey
	val id: Int,
	val title: String,
	val director: String,
	val producer: String,
	val discription: String
)