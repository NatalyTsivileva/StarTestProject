package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PlanetMovieAggr

data class PlanetWithMovie(
	@Embedded val planet: PlanetEntity,
	@Relation(
		parentColumn = "id",
		entityColumn = "id",
		associateBy = Junction(
			value = PlanetMovieAggr::class,
			parentColumn = "planetId",
			entityColumn = "movieId"
		)
	)
	val movies: List<MovieEntity>
)
