package com.civileva.nata.cocktail.startestproject.db.entity.favorite

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity

@Entity(
	tableName = "FavoritePerson",
	indices = [Index(value = ["personId"], unique = true)],

	foreignKeys = [
		ForeignKey(
			entity = PersonEntity::class,
			parentColumns = ["id"],
			childColumns = ["personId"],
			onDelete = ForeignKey.CASCADE,
			onUpdate = ForeignKey.CASCADE
		)]
)
data class FavoritePersonEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	var personId: Int
)