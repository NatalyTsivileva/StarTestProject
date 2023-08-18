package com.civileva.nata.cocktail.startestproject

import com.civileva.nata.cocktail.startestproject.data.model.Planet
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.network.converter.PlanetModelConverter
import com.civileva.nata.cocktail.startestproject.network.model.PlanetNetworkModel
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PlanetNetworkModelTest {
	private val decoder = Json { ignoreUnknownKeys = true }

	@Test
	fun `when parse PlanetNetworkModel-should return Planet's instance`() {
		val actualNetworkModel = decoder.decodeFromString<PlanetNetworkModel>(planetJSON)

		val actualEntities: List<PlanetEntity> =
			actualNetworkModel.planetData.map { PlanetModelConverter.toPlanetEntity(it) }
		val actualData: List<Planet> = actualEntities.map { PlanetModelConverter.toPlanet(it) }

		Assert.assertEquals(expectedPlanet, actualData.firstOrNull())
		Assert.assertEquals(1, actualData.count())
	}

	companion object {
		val planetJSON = "{" +
				"    \"count\": 1," +
				"    \"next\": null," +
				"    \"previous\": null," +
				"    \"results\": [" +
				"        {" +
				"            \"name\": \"Malastare\"," +
				"            \"rotation_period\": \"26\"," +
				"            \"orbital_period\": \"201\"," +
				"            \"diameter\": \"18880\"," +
				"            \"climate\": \"arid, temperate, tropical\"," +
				"            \"gravity\": \"1.56\"," +
				"            \"terrain\": \"swamps, deserts, jungles, mountains\"," +
				"            \"surface_water\": \"unknown\"," +
				"            \"population\": \"2000000000\"," +
				"            \"residents\": [" +
				"                \"https://swapi.dev/api/people/41/\"" +
				"            ]," +
				"            \"films\": []," +
				"            \"created\": \"2014-12-19T17:52:13.106000Z\"," +
				"            \"edited\": \"2014-12-20T20:58:18.478000Z\"," +
				"            \"url\": \"https://swapi.dev/api/planets/35/\"" +
				"        }" +
				"    ]" +
				"}"

		val expectedPlanet = Planet(
			id = 35,
			name = "Malastare",
			diameter = 18880,
			populationInfo = "2000000000"
		)
	}
}