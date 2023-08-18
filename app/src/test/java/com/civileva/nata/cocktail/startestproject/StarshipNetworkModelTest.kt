package com.civileva.nata.cocktail.startestproject

import com.civileva.nata.cocktail.startestproject.data.model.Starship
import com.civileva.nata.cocktail.startestproject.db.entity.StarshipEntity
import com.civileva.nata.cocktail.startestproject.network.converter.StarshipModelConverter
import com.civileva.nata.cocktail.startestproject.network.model.StarhipNetworkModel
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class StarshipNetworkModelTest {
	private val decoder = Json { ignoreUnknownKeys = true }


	@Test
	fun `when parse StarshipNetworkModel-should return Starship's instance`() {
		val actualNetworkModel = decoder.decodeFromString<StarhipNetworkModel>(starshipJSON)

		val actualEntities: List<StarshipEntity> =
			actualNetworkModel.starshipData.map { StarshipModelConverter.toStarshipEntity(it) }
		val actualData: List<Starship> =
			actualEntities.map { StarshipModelConverter.toStarship(it) }

		Assert.assertEquals(expectedStarship, actualData.firstOrNull())
		Assert.assertEquals(1, actualData.count())
	}

	companion object {
		val starshipJSON = "" +
				"{" +
				"    \"count\": 1," +
				"    \"next\": null," +
				"    \"previous\": null," +
				"    \"results\": [" +
				"        {" +
				"            \"name\": \"Death Star\"," +
				"            \"model\": \"DS-1 Orbital Battle Station\"," +
				"            \"manufacturer\": \"Imperial Department of Military Research, Sienar Fleet Systems\"," +
				"            \"cost_in_credits\": \"1000000000000\"," +
				"            \"length\": \"120000\"," +
				"            \"max_atmosphering_speed\": \"n/a\"," +
				"            \"crew\": \"342,953\"," +
				"            \"passengers\": \"843,342\"," +
				"            \"cargo_capacity\": \"1000000000000\"," +
				"            \"consumables\": \"3 years\"," +
				"            \"hyperdrive_rating\": \"4.0\"," +
				"            \"MGLT\": \"10\"," +
				"            \"starship_class\": \"Deep Space Mobile Battlestation\"," +
				"            \"pilots\": []," +
				"            \"films\": [" +
				"                \"https://swapi.dev/api/films/1/\"" +
				"            ]," +
				"            \"created\": \"2014-12-10T16:36:50.509000Z\"," +
				"            \"edited\": \"2014-12-20T21:26:24.783000Z\"," +
				"            \"url\": \"https://swapi.dev/api/starships/9/\"" +
				"        }" +
				"    ]" +
				"}"
		val expectedStarship = Starship(
			id = 9,
			name = "Death Star",
			model = "DS-1 Orbital Battle Station",
			manufacturer = "Imperial Department of Military Research, Sienar Fleet Systems",
			passengersInfo = "843,342"
		)
	}
}