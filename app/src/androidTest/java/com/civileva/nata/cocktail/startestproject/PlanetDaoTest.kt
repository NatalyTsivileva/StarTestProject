package com.civileva.nata.cocktail.startestproject

import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PlanetEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PlanetMovieAggr
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class PlanetDaoTest {
	@get:Rule
	var databaseRule = DatabaseTestRules()

	@Test
	fun planetInsertingTest() {
		val dao = databaseRule.database?.planetDao()
		dao?.add(expectedPlanet)

		val data = dao?.getPlanetWithMovies()

		Assert.assertEquals(1, data?.count())
		Assert.assertEquals(0, data?.firstOrNull()?.movies?.count())
		Assert.assertEquals(expectedPlanet, data?.firstOrNull()?.planet)
	}

	@Test
	fun planetWithMovieInsertingTest() {
		val db = databaseRule.database
		db?.planetDao()?.add(expectedPlanet)
		db?.movieDao()?.add(expectedMovie)

		db?.aggregatorDao()?.bindPlanetWithMovie(
			PlanetMovieAggr(
				movieId = expectedMovie.id,
				planetId = expectedPlanet.id
			)
		)

		val data = db?.planetDao()?.getPlanetWithMovies()

		Assert.assertEquals(1, data?.count())
		Assert.assertEquals(1, data?.firstOrNull()?.movies?.count())

		Assert.assertEquals(expectedPlanet, data?.firstOrNull()?.planet)
		Assert.assertEquals(expectedMovie, data?.firstOrNull()?.movies?.firstOrNull())
	}

	companion object {
		val expectedPlanet =
			PlanetEntity(id = 1, diameter = 10000, name = "Tatooine", population = "200,230")

		val expectedMovie = MovieEntity(
			4,
			title = "A New Hope",
			director = "George Lucas",
			producer = "Gary Kurtz, Rick McCallum",
			discription = "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy...."
		)
	}
}