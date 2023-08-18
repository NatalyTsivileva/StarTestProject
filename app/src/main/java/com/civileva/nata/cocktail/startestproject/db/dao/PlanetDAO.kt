package com.civileva.nata.cocktail.startestproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.dto.FavoritePlanetWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.dto.PlanetWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePlanetEntity

@Dao
interface PlanetDAO {
	@Insert
	fun add(planet: PlanetEntity)

	@Insert
	fun addFavorite(favorite: FavoritePlanetEntity)

	@Transaction
	@Query("SELECT * FROM Planet")
	fun getPlanetWithMovies(): List<PlanetWithMovie>

	@Transaction
	@Query("SELECT * FROM FavoritePlanet")
	fun getFavoritePlanetWithMovies(): List<FavoritePlanetWithMovie>
}