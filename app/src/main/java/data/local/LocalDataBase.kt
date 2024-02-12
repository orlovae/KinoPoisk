package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.models.MovieDb

@Database(entities = [MovieDb::class], version = 1)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}
