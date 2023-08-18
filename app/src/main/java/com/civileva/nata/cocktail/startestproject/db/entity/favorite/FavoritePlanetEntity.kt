package com.civileva.nata.cocktail.startestproject.db.entity.favorite

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity

@Entity(
	tableName = "FavoritePlanet",
	indices = [Index(value = ["planetId"], unique = true)],

	foreignKeys = [
		ForeignKey(
			entity = PlanetEntity::class,
			parentColumns = ["id"],
			childColumns = ["planetId"],
			onDelete = ForeignKey.CASCADE,
			onUpdate = ForeignKey.CASCADE
		)]
)
data class FavoritePlanetEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	val planetId: Int
)