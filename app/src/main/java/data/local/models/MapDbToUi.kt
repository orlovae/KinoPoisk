package data.local.models

import common.data.Mapper
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

class MapDbToUi : Mapper<MovieDb, PopularMovieUI> {

    override fun transform(data: MovieDb): PopularMovieUI =
        PopularMovieUI(
            id = data.id,
            preview = data.preview,
            title = data.title,
            genre = data.genre,
            country = data.country,
            year = data.year,
            favorite = data.favorite,
        )
}
