package com.civileva.nata.cocktail.startestproject.network.converter

import com.civileva.nata.cocktail.startestproject.data.model.Starship
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.network.model.StarhipNetworkModel
import com.civileva.nata.cocktail.startestproject.utils.IdParser

object StarshipModelConverter {

	fun toStarshipEntity(networkData: StarhipNetworkModel.Data): StarshipEntity {
		return StarshipEntity(
			id = IdParser.parseId(networkData.url),
			name = networkData.name,
			manufacture = networkData.manufacturer,
			model = networkData.model,
			passenger = networkData.passengers
		)
	}

	fun toStarship(entity: StarshipEntity): Starship {
		return Starship(
			id = entity.id,
			name = entity.name,
			model = entity.model,
			manufacturer = entity.manufacture,
			passengersInfo = entity.passenger
		)
	}
}