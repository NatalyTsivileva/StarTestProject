package com.civileva.nata.cocktail.startestproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PersonMovieAggr
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PlanetMovieAggr
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.StarshipMovieAggr

@Dao
interface AggregatorDAO {
	@Insert
	fun add(movieEntity: MovieEntity)

	@Insert
	fun add(movies: List<MovieEntity>)


	@Insert
	fun bindPersonWithMovie(aggregator: PersonMovieAggr)
	@Insert
	fun bindPersonsWithMovie(aggregators: List<PersonMovieAggr>)


	@Insert
	fun bindStarshipWithMovie(aggregator: StarshipMovieAggr)
	@Insert
	fun bindStarshipsWithMovie(aggregators: List<StarshipMovieAggr>)


	@Insert
	fun bindPlanetWithMovie(aggregator: PlanetMovieAggr)
	@Insert
	fun bindPlanetsWithMovie(aggregators: List<PlanetMovieAggr>)

}