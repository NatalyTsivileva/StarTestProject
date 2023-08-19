package com.civileva.nata.cocktail.startestproject.model

import com.civileva.nata.cocktail.startestproject.data.model.Movie
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.network.converter.MovieModelConverter
import com.civileva.nata.cocktail.startestproject.network.model.MovieNetworkModel
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class MovieNetworkModelTest {
	private val decoder = Json { ignoreUnknownKeys = true }

	@Test
	fun `when parse MovieNetworkModel-should return list of Movie`() {
		val actualNetworkModel = decoder.decodeFromString<MovieNetworkModel>(movieJSON)

		val actualEntities: List<MovieEntity> =
			actualNetworkModel.movieData.map { MovieModelConverter.toMovieEntity(it) }
		val actualData: List<Movie> = actualEntities.map { MovieModelConverter.toMovie(it) }

		Assert.assertEquals(expectedMovie, actualData)
		Assert.assertEquals(expectedMovie.count(), actualData.count())
	}

	companion object {

		val expectedMovie = listOf(
			Movie(
				id = 4,
				name = "A New Hope",
				director = "George Lucas",
				producer = "Gary Kurtz, Rick McCallum"
			)
		)
		val movieJSON = "{" +
				" \"count\": 6," +
				"    \"next\": null," +
				"    \"previous\": null," +
				"    \"results\": [" +
				"        {" +
				"            \"title\": \"A New Hope\"," +
				"            \"episode_id\": 4," +
				"            \"opening_crawl\": \"It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.  During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet.  Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy....\"," +
				"            \"director\": \"George Lucas\"," +
				"            \"producer\": \"Gary Kurtz, Rick McCallum\"," +
				"            \"release_date\": \"1977-05-25\"," +
				"            \"characters\": [" +
				"                \"https://swapi.dev/api/people/1/\"," +
				"                \"https://swapi.dev/api/people/2/\"," +
				"                \"https://swapi.dev/api/people/3/\"," +
				"                \"https://swapi.dev/api/people/4/\"," +
				"                \"https://swapi.dev/api/people/5/\"," +
				"                \"https://swapi.dev/api/people/6/\"," +
				"                \"https://swapi.dev/api/people/7/\"," +
				"                \"https://swapi.dev/api/people/8/\"," +
				"                \"https://swapi.dev/api/people/9/\"," +
				"                \"https://swapi.dev/api/people/10/\"," +
				"                \"https://swapi.dev/api/people/12/\"," +
				"                \"https://swapi.dev/api/people/13/\"," +
				"                \"https://swapi.dev/api/people/14/\"," +
				"                \"https://swapi.dev/api/people/15/\"," +
				"                \"https://swapi.dev/api/people/16/\"," +
				"                \"https://swapi.dev/api/people/18/\"," +
				"                \"https://swapi.dev/api/people/19/\"," +
				"                \"https://swapi.dev/api/people/81/\"" +
				"            ]," +
				"            \"planets\": [" +
				"                \"https://swapi.dev/api/planets/1/\"," +
				"                \"https://swapi.dev/api/planets/2/\"," +
				"                \"https://swapi.dev/api/planets/3/\"" +
				"            ]," +
				"            \"starships\": [" +
				"                \"https://swapi.dev/api/starships/2/\"," +
				"                \"https://swapi.dev/api/starships/3/\"," +
				"                \"https://swapi.dev/api/starships/5/\"," +
				"                \"https://swapi.dev/api/starships/9/\"," +
				"                \"https://swapi.dev/api/starships/10/\"," +
				"                \"https://swapi.dev/api/starships/11/\"," +
				"                \"https://swapi.dev/api/starships/12/\"," +
				"                \"https://swapi.dev/api/starships/13/\"" +
				"            ]," +
				"            \"vehicles\": [" +
				"                \"https://swapi.dev/api/vehicles/4/\"," +
				"                \"https://swapi.dev/api/vehicles/6/\"," +
				"                \"https://swapi.dev/api/vehicles/7/\"," +
				"                \"https://swapi.dev/api/vehicles/8/\"" +
				"            ]," +
				"            \"species\": [" +
				"                \"https://swapi.dev/api/species/1/\"," +
				"                \"https://swapi.dev/api/species/2/\"," +
				"                \"https://swapi.dev/api/species/3/\"," +
				"                \"https://swapi.dev/api/species/4/\"," +
				"                \"https://swapi.dev/api/species/5/\"" +
				"            ]," +
				"            \"created\": \"2014-12-10T14:23:31.880000Z\"," +
				"            \"edited\": \"2014-12-20T19:49:45.256000Z\"," +
				"            \"url\": \"https://swapi.dev/api/films/1/\"" +
				"        }" +
				"    ]" +
				"}"
	}
}