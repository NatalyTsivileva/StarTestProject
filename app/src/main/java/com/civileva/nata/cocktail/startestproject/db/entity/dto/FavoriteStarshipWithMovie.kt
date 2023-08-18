package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoriteStarshipEntity

data class FavoriteStarshipWithMovie (
	@Embedded val starship: FavoriteStarshipEntity,
	@Relation(
		entity = StarshipEntity::class,
		parentColumn = "starshipId",
		entityColumn = "id"
	)
	val starshipWithMovie: List<StarshipWithMovie>
)