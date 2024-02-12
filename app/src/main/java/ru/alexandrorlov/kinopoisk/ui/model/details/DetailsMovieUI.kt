package ru.alexandrorlov.kinopoisk.ui.model.details

data class DetailsMovieUI(
    val id: Int,
    val poster: String,
    val title: String,
    val description: String,
    val genres: String,
    val countries: String,
    val year: String,
)
