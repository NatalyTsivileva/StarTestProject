package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePlanetEntity

data class FavoritePlanetWithMovie (
	@Embedded val planet: FavoritePlanetEntity,
	@Relation(
		entity = PlanetEntity::class,
		parentColumn = "planetId",
		entityColumn = "id"
	)
	val planetWithMovie: List<PlanetWithMovie>
)