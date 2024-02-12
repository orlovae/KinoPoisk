package data.network.api

import common.data.Either
import data.network.models.popular.MovieNetwork

internal interface TopMovieRepository {
    suspend fun getTopMovie(): Either<Exception, List<MovieNetwork>>
}
