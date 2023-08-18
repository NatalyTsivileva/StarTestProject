package com.civileva.nata.cocktail.startestproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.db.entity.dto.FavoriteStarshipWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.dto.StarshipWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoriteStarshipEntity

@Dao
interface StarshipDAO {
	@Insert
	fun add(starshipEntity: StarshipEntity)

	@Insert
	fun addFavorite(favorite: FavoriteStarshipEntity)

	@Transaction
	@Query("SELECT * FROM Starship")
	fun getStarshipWithMovie(): List<StarshipWithMovie>

	@Transaction
	@Query("SELECT * FROM FavoriteStarship")
	fun getFavoriteStarshipWithMovie(): List<FavoriteStarshipWithMovie>
}