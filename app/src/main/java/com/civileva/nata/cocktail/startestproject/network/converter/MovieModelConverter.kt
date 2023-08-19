package com.civileva.nata.cocktail.startestproject.network.converter

import com.civileva.nata.cocktail.startestproject.data.model.Movie
import com.civileva.nata.cocktail.startestproject.db.entity.MovieEntity
import com.civileva.nata.cocktail.startestproject.network.model.MovieNetworkModel

object MovieModelConverter {
	fun toMovieEntity(data: MovieNetworkModel.Data): MovieEntity {
		return MovieEntity(
			id = data.id,
			title = data.title,
			director = data.director,
			producer = data.producer
		)
	}

	fun toMovie(entity: MovieEntity): Movie {
		return Movie(
			id = entity.id,
			name = entity.title,
			director = entity.director,
			producer = entity.producer
		)
	}
}