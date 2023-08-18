package com.civileva.nata.cocktail.startestproject.db.entity.aggr

import androidx.room.*

@Entity(
	primaryKeys = ["movieId","starshipId"]
)
data class StarshipMovieAggr(
	@ColumnInfo(index = true)
	val movieId: Int,

	@ColumnInfo(index = true)
	val starshipId: Int
)