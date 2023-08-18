package com.civileva.nata.cocktail.startestproject.network.converter

import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.network.model.PersonNetworkModel
import com.civileva.nata.cocktail.startestproject.utils.IdParser

object PersonModelConverter {

	fun toPersonEntity(networkData: PersonNetworkModel.Data): PersonEntity {
		return PersonEntity(
			id = IdParser.parseId(networkData.url),
			name = networkData.name,
			gender = Person.toGender(networkData.gender),
			starshipCount = networkData.starships.count()
		)
	}

	fun toPerson(entity: PersonEntity): Person {
		return Person(
			id = entity.id,
			name = entity.name,
			gender = entity.gender,
			starshipsCount = entity.starshipCount
		)
	}
}