package com.civileva.nata.cocktail.startestproject

import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.db.entity.PersonEntity
import com.civileva.nata.cocktail.startestproject.db.entity.aggr.PersonMovieAggr
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class PersonDaoTest {
	@get:Rule
	var databaseRule = DatabaseTestRules()

	@Test
	fun personInsertingTest() {
		val dao = databaseRule.database?.personDao()
		dao?.add(expectedPerson)

		val data = dao?.getPersonsWithMovies()

		Assert.assertEquals(1, data?.count())
		Assert.assertEquals(0, data?.firstOrNull()?.movies?.count())
		Assert.assertEquals(expectedPerson, data?.firstOrNull()?.person)
	}


	@Test
	fun personAndMovieInsertingTest() {
		val db = databaseRule.database
		db?.personDao()?.add(expectedPerson)
		db?.movieDao()?.add(expectedMovie)

		db?.aggregatorDao()?.bindPersonWithMovie(
			PersonMovieAggr(
				movieId = expectedMovie.id,
				personId = expectedPerson.id
			)
		)

		val data = db?.personDao()?.getPersonsWithMovies()

		Assert.assertEquals(1, data?.count())
		Assert.assertEquals(1, data?.firstOrNull()?.movies?.count())

		Assert.assertEquals(expectedPerson, data?.firstOrNull()?.person)
		Assert.assertEquals(expectedMovie, data?.firstOrNull()?.movies?.firstOrNull())
	}

	companion object {
		val expectedPerson = PersonEntity(1, "Luke Skywalker", true, 2)
		val expectedMovie = MovieEntity(
			4,
			title = "A New Hope",
			director = "George Lucas",
			producer = "Gary Kurtz, Rick McCallum",
			discription = "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy...."
		)
	}
}