package data.local.models

import common.data.Mapper
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

class MapDbToUi : Mapper<List<MovieDb>, List<PopularMovieUI>> {

    override fun transform(data: List<MovieDb>): List<PopularMovieUI> {
        val list = mutableListOf<PopularMovieUI>()

        data.forEach { movieDb ->
            list.add(
                PopularMovieUI(
                    id = movieDb.id,
                    preview = movieDb.preview,
                    title = movieDb.title,
                    genre = movieDb.genre,
                    country = movieDb.country,
                    year = movieDb.year,
                    favorite = movieDb.favorite,
                ),
            )
        }

        return list.toList()
    }
}
