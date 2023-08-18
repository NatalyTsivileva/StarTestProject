package com.civileva.nata.cocktail.startestproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.dto.FavoritePersonWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.dto.PersonWithMovie
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePersonEntity

@Dao
interface PersonDAO {
	@Insert
	fun add(personEntity: PersonEntity)

	@Insert
	fun addFavorite(favorite: FavoritePersonEntity)

	@Transaction
	@Query("SELECT * FROM Person")
	fun getPersonsWithMovies():List<PersonWithMovie>

	@Transaction
	@Query("SELECT * FROM FavoritePerson")
	fun getFavoritePersonWithMovies(): List<FavoritePersonWithMovie>

}