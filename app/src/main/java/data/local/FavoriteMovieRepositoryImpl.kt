package data.local

import data.local.api.FavoriteMovieRepository
import data.local.models.MovieDb

internal class FavoriteMovieRepositoryImpl(private val db: LocalDataBase) : FavoriteMovieRepository {

    override suspend fun getAllMovie(): List<MovieDb> {
        return db.MovieDao().getAll()
    }

    override suspend fun insertMovieDb(movieDb: MovieDb) {
        db.MovieDao().insertMovieDb(movieDb)
    }

    override suspend fun insertAll(list: List<MovieDb>) {
        db.MovieDao().insertAll(list)
    }

    override suspend fun deleteMovieDb(movieDb: MovieDb) {
        db.MovieDao().deleteMovieDb(movieDb)
    }

    override suspend fun deleteAll() {
        db.MovieDao().deleteAll()
    }
}
