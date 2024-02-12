package network.api

import common.data.Either
import network.models.popular.Movie

internal interface TopMovieRepository {
    suspend fun getTopMovie(): Either<Exception, List<Movie>>
}
