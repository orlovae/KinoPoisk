package data.local.api

import data.local.models.MovieDb

interface FavoriteMovieRepository {

    suspend fun getAllMovie(): List<MovieDb>

    suspend fun insertMovieDb(movieDb: MovieDb)

    suspend fun insertAll(list: List<MovieDb>)

    suspend fun deleteMovieDb(movieDb: MovieDb)

    suspend fun deleteAll()
}
