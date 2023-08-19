package com.civileva.nata.cocktail.startestproject.model

import com.civileva.nata.cocktail.startestproject.data.model.Person
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.network.converter.PersonModelConverter
import com.civileva.nata.cocktail.startestproject.network.model.PersonNetworkModel
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PersonNetworkModelTest {
	private val decoder = Json { ignoreUnknownKeys = true }

	@Test
	fun `when parse PersonNetworkModel-should return Person's instance`() {
		val actualNetworkModel = decoder.decodeFromString<PersonNetworkModel>(personJSON)

		val actualEntities: List<PersonEntity> =
			actualNetworkModel.personData.map { PersonModelConverter.toPersonEntity(it) }
		val actualData: List<Person> = actualEntities.map { PersonModelConverter.toPerson(it) }

		Assert.assertEquals(expectedPerson, actualData.firstOrNull())
		Assert.assertEquals(1, actualData.count())
	}

	companion object {
		val personJSON = "{\"count\": 1," +
				"\"next\": null," +
				"\"previous\": null," +
				"\"results\": [ " +
				"{\"name\": \"Luke Skywalker\"," +
				"\"height\": \"172\"," +
				"\"mass\": \"77\"," +
				"\"hair_color\": \"blond\"," +
				"\"skin_color\": \"fair\"," +
				"\"eye_color\": \"blue\"," +
				"\"birth_year\": \"19BBY\"," +
				"\"gender\": \"male\"," +
				"\"homeworld\": \"https://swapi.dev/api/planets/1/\"," +
				"\"films\": [\"https://swapi.dev/api/films/1/\"," +
				"\"https://swapi.dev/api/films/2/\"," +
				"\"https://swapi.dev/api/films/3/\"," +
				"\"https://swapi.dev/api/films/6/\"]," +
				"\"species\": []," +
				"\"vehicles\": [\"https://swapi.dev/api/vehicles/14/\"," +
				" \"https://swapi.dev/api/vehicles/30/\"]," +
				"\"starships\": [\"https://swapi.dev/api/starships/12/\"," +
				"\"https://swapi.dev/api/starships/22/\"]," +
				"\"created\": \"2014-12-09T13:50:51.644000Z\"," +
				"\"edited\": \"2014-12-20T21:17:56.891000Z\"," +
				"\"url\": \"https://swapi.dev/api/people/1/\"}" +
				"]" +
				"}"

		val expectedPerson = Person(
			id = 1,
			name = "Luke Skywalker",
			Person.GENDER.MALE,
			2
		)
	}
}