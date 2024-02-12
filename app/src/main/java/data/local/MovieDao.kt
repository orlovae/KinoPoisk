package data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.local.models.MovieDb

@Dao
interface MovieDao {
    @Query("SELECT * FROM ${LocalConstant.Movie.TABLE_NAME}")
    suspend fun getAll(): List<MovieDb>

    @Insert
    suspend fun insertMovieDb(movieDb: MovieDb)

    @Insert
    suspend fun insertAll(movieDbList: List<MovieDb>)

    @Delete
    suspend fun deleteMovieDb(movieDb: MovieDb)

    @Query("DELETE FROM ${LocalConstant.Movie.TABLE_NAME}")
    suspend fun deleteAll()
}
