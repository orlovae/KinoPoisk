package data.network

import common.data.Either
import data.network.NetworkConstants.BASE_URL
import data.network.NetworkConstants.HEADER_KEY
import data.network.NetworkConstants.KEY
import data.network.NetworkConstants.KTOR
import data.network.NetworkConstants.REQUEST_PARAMETER_TOP_KEY
import data.network.NetworkConstants.REQUEST_PARAMETER_TOP_VALUE
import data.network.api.TopMovieRepository
import data.network.models.popular.MovieNetwork
import data.network.models.popular.PopularMovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

internal class TopMovieRepositoryImpl(private val ktorApi: HttpClient) : TopMovieRepository {
    override suspend fun getTopMovie(): Either<Exception, List<MovieNetwork>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val response: PopularMovieResponse =
                    ktorApi.get(BASE_URL) {
                        headers.append(
                            name = HEADER_KEY,
                            value = KEY,
                        )
                        parameter(
                            key = REQUEST_PARAMETER_TOP_KEY,
                            value = REQUEST_PARAMETER_TOP_VALUE,
                        )
                    }.body()
                Either.success(response.movies)
            } catch (e: Exception) {
                Timber.tag(KTOR)
                    .d("Error ${TopMovieRepositoryImpl::class.simpleName}: ${e.message}")
                Either.fail(e)
            }
        }
}
