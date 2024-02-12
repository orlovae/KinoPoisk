package ru.alexandrorlov.kinopoisk.ui.model.popular

import common.data.Mapper
import data.network.models.popular.MovieNetwork

class MapToPopularMovieUI : Mapper<MovieNetwork, PopularMovieUI> {
    override fun transform(data: MovieNetwork): PopularMovieUI =
        PopularMovieUI(
            id = data.kinopoiskId ?: 0,
            preview = data.posterUrlPreview ?: "",
            title = data.nameRu ?: "",
            genre = data.genres.first().genre ?: "",
            country = data.countries.first().country ?: "",
            year = data.year?.toString() ?: "",
            favorite = false,
        )
}
