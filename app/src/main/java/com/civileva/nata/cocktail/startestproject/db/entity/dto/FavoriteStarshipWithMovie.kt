package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoriteStarshipEntity

data class FavoriteStarshipWithMovie(
	@Embedded val starship: FavoriteStarshipEntity,
	@Relation(
		entity = StarshipEntity::class,
		parentColumn = "starshipId",
		entityColumn = "id"
	)
	val starshipWithMovie: List<StarshipWithMovie>
)