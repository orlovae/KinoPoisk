package ru.alexandrorlov.kinopoisk.ui.model.details

import common.data.Mapper
import network.models.details.DetailsMovieResponse

class MapToDetailsMovieUI : Mapper<DetailsMovieResponse, DetailsMovieUI> {

    override fun transform(data: DetailsMovieResponse): DetailsMovieUI =
        DetailsMovieUI(
            poster = data.posterUrl ?: "",
            title = data.nameRu ?: "",
            description = data.description ?: "",
            genres = data.genres.joinToString {
                it.genre.toString()
            },
            countries = data.countries.joinToString {
                it.country.toString()
            },
            year = data.year.toString(),
        )
}
