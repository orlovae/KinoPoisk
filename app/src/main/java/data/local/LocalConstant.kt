package data.local

object LocalConstant {
    const val DATABASE_NAME = "movies.db"

    object Movie {
        const val TABLE_NAME = "Movies"
        const val COLUMN_ID = "id"
        const val COLUMN_PREVIEW = "preview"
        const val COLUMN_TITLE = "title"
        const val COLUMN_GENRE = "genre"
        const val COLUMN_COUNTIES = "counties"
        const val COLUMN_YEAR = "year"
        const val COLUMN_FAVORITES = "favorites"
    }
}
