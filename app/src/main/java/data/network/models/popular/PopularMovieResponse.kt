package data.network.models.popular

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    @SerialName("items")
    val movies: List<MovieNetwork>,
    @SerialName("total")
    val total: Int,
    @SerialName("totalPages")
    val totalPages: Int,
)
