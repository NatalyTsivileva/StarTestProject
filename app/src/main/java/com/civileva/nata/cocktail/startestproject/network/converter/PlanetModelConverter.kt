package com.civileva.nata.cocktail.startestproject.network.converter

import com.civileva.nata.cocktail.startestproject.data.model.Planet
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.network.model.PlanetNetworkModel
import com.civileva.nata.cocktail.startestproject.utils.IdParser

object PlanetModelConverter {

	fun toPlanetEntity(networkData: PlanetNetworkModel.Data): PlanetEntity {
		return PlanetEntity(
			id = IdParser.parseId(networkData.url),
			name = networkData.name,
			diameter = networkData.diameter,
			population = networkData.population
		)
	}

	fun toPlanet(entity: PlanetEntity): Planet {
		return Planet(
			id = entity.id,
			name = entity.name,
			diameter = entity.diameter,
			populationInfo = entity.population
		)
	}
}