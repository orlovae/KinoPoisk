package network

import common.data.Either
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import network.api.DetailMovieRepository
import network.models.details.DetailsMovieResponse
import timber.log.Timber

class DetailMovieRepositoryImpl(private val ktorApi: HttpClient) : DetailMovieRepository {

    override suspend fun getDetailMovie(idMovie: Int): Either<Exception, DetailsMovieResponse> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response: DetailsMovieResponse =
                    ktorApi.get("${NetworkConstants.DETAIL_MOVIE_URL}$idMovie") {
                        headers.append(
                            name = NetworkConstants.HEADER_KEY,
                            value = NetworkConstants.KEY,
                        )
                    }.body()
                Either.success(response)
            } catch (e: Exception) {
                Timber.tag(NetworkConstants.KTOR)
                    .d("Error ${DetailMovieRepositoryImpl::class.simpleName}: ${e.message}")
                Either.fail(e)
            }
        }
}
