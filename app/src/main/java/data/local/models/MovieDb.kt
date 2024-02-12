package data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import data.local.LocalConstant

@Entity(tableName = LocalConstant.Movie.TABLE_NAME)
data class MovieDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_ID)
    val id: Int,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_PREVIEW)
    val preview: String,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_TITLE)
    val title: String,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_GENRE)
    val genre: String,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_COUNTRY)
    val country: String,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_YEAR)
    val year: String,
    @ColumnInfo(name = LocalConstant.Movie.COLUMN_FAVORITES)
    val favorite: Boolean,
)
