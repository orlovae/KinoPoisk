package ru.alexandrorlov.kinopoisk.ui.model.popular

data class PopularMovieUI(
    val id: Int,
    val preview: String,
    val title: String,
    val genre: String,
    val country: String,
    val year: String,
    val favorite: Boolean = false,
)
