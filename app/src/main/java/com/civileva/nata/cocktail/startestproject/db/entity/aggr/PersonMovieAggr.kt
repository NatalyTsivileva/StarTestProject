package com.civileva.nata.cocktail.startestproject.db.entity.aggr

import androidx.room.*

@Entity(
	primaryKeys = ["movieId","personId"],
)
data class PersonMovieAggr(
	@ColumnInfo(index = true)
	val movieId: Int,

	@ColumnInfo(index = true)
	val personId: Int
)