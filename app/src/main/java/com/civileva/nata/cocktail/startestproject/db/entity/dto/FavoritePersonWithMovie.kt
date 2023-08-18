package com.civileva.nata.cocktail.startestproject.db.entity.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.favorite.FavoritePersonEntity

data class FavoritePersonWithMovie(
	@Embedded val person: FavoritePersonEntity,
	@Relation(
		entity = PersonEntity::class,
		parentColumn = "personId",
		entityColumn = "id"
	)
	val personWithMovie: List<PersonWithMovie>
)