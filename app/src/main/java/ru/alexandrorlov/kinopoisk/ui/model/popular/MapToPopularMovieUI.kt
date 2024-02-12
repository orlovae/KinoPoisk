package ru.alexandrorlov.kinopoisk.ui.model.popular

import common.data.Mapper
import data.network.models.popular.Movie

class MapToPopularMovieUI : Mapper<Movie, PopularMovieUI> {
    override fun transform(data: Movie): PopularMovieUI =
        PopularMovieUI(
            id = data.kinopoiskId ?: 0,
            preview = data.posterUrlPreview ?: "",
            title = data.nameRu ?: "",
            genres = data.genres.map {
                it.genre.toString()
            },
            counties = data.countries.map {
                it.country.toString()
            },
            year = data.year?.toString() ?: "",
            favorite = false,
        )
}
