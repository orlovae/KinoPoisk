package network.api

import common.data.Either
import network.models.details.DetailsMovieResponse

interface DetailMovieRepository {
    suspend fun getDetailMovie(idMovie: Int): Either<Exception, DetailsMovieResponse>
}
