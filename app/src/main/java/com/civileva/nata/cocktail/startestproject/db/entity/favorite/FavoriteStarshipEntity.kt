package com.civileva.nata.cocktail.startestproject.db.entity.favorite

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity

@Entity(
	tableName = "FavoriteStarship",
	indices = [Index(value = ["starshipId"], unique = true)],

	foreignKeys = [
		ForeignKey(
			entity = StarshipEntity::class,
			parentColumns = ["id"],
			childColumns = ["starshipId"],
			onDelete = ForeignKey.CASCADE,
			onUpdate = ForeignKey.CASCADE
		)]
)
data class FavoriteStarshipEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	val starshipId: Int
)