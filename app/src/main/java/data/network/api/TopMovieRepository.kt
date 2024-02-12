package data.network.api

import common.data.Either
import data.network.models.popular.Movie

internal interface TopMovieRepository {
    suspend fun getTopMovie(): Either<Exception, List<Movie>>
}
