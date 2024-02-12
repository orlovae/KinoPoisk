package network.models.popular

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    @SerialName("items")
    val movies: List<Movie>,
    @SerialName("total")
    val total: Int,
    @SerialName("totalPages")
    val totalPages: Int,
)
