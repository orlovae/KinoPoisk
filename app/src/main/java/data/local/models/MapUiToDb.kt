package data.local.models

import common.data.Mapper
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

class MapUiToDb : Mapper<PopularMovieUI, MovieDb> {
    override fun transform(data: PopularMovieUI): MovieDb =
        MovieDb(
            id = data.id,
            preview = data.preview,
            title = data.title,
            genre = data.genre,
            country = data.country,
            year = data.year,
            favorite = data.favorite,
        )
}
