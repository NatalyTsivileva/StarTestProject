package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PersonMovieAggr

data class PersonWithMovie(
	@Embedded val person: PersonEntity,
	@Relation(
		parentColumn = "id",
		entityColumn = "id",
		associateBy = Junction(
			value = PersonMovieAggr::class,
			parentColumn = "personId",
			entityColumn = "movieId"
		)
	)
	val movies: List<MovieEntity>
)