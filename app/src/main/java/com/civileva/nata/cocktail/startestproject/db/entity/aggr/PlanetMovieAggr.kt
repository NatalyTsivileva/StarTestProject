package com.civileva.nata.cocktail.startestproject.db.entity.aggr

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
	primaryKeys = ["movieId", "planetId"]
)
data class PlanetMovieAggr(
	@ColumnInfo(index = true)
	val movieId: Int,

	@ColumnInfo(index = true)
	val planetId: Int
)