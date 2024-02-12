package ru.alexandrorlov.kinopoisk.ui.model.details

import common.data.Mapper
import data.network.models.details.DetailsMovieResponse

class MapToDetailsMovieUI : Mapper<DetailsMovieResponse, DetailsMovieUI> {

    override fun transform(data: DetailsMovieResponse): DetailsMovieUI =
        DetailsMovieUI(
            id = data.kinopoiskId ?: -1,
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
