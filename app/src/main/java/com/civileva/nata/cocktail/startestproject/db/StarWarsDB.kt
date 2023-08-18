package com.civileva.nata.cocktail.startestproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.civileva.nata.cocktail.startestproject.db.dao.*
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PersonMovieAggr
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PlanetMovieAggr
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.StarshipMovieAggr
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoriteStarshipEntity

@Database(
	version = 1,
	exportSchema = false,
	entities = [
		PersonEntity::class,
		StarshipEntity::class,
		PlanetEntity::class,
		MovieEntity::class,

		FavoritePersonEntity::class,
		FavoriteStarshipEntity::class,
		FavoritePlanetEntity::class,

		PersonMovieAggr::class,
		StarshipMovieAggr::class,
		PlanetMovieAggr::class
	]
)
abstract class StarWarsDB : RoomDatabase() {
	abstract fun movieDao(): MovieDAO
	abstract fun personDao(): PersonDAO
	abstract fun starshipDao(): StarshipDAO
	abstract fun planetDao(): PlanetDAO
	abstract fun aggregatorDao(): AggregatorDAO
}