package data.network.models.popular

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("kinopoiskId")
    val kinopoiskId: Int?,
    @SerialName("imdbId")
    val imdbId: String?,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("nameEn")
    val nameEn: String?,
    @SerialName("nameOriginal")
    val nameOriginal: String?,
    @SerialName("countries")
    val countries: List<Country>,
    @SerialName("genres")
    val genres: List<Genre>,
    @SerialName("ratingKinopoisk")
    val ratingKinopoisk: String?,
    @SerialName("ratingImdb")
    val ratingImdb: String?,
    @SerialName("year")
    val year: Int?,
    @SerialName("type")
    val type: String?,
    @SerialName("posterUrl")
    val posterUrl: String?,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String?,
)
