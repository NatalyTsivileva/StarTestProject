package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.StarshipMovieAggr

class StarshipWithMovie(
	@Embedded val starshipEntity: StarshipEntity,
	@Relation(
		parentColumn = "id",
		entityColumn = "id",
		associateBy = Junction(
			value = StarshipMovieAggr::class,
			parentColumn = "starshipId",
			entityColumn = "movieId"
		)
	)
	val movies: List<MovieEntity>
)