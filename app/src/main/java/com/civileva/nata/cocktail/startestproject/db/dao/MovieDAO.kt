package com.civileva.nata.cocktail.startestproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity

@Dao
interface MovieDAO {
	@Insert
	fun add(movieEntity: MovieEntity)

	@Insert
	fun add(movies: List<MovieEntity>)

}