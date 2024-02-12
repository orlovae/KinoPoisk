package ru.alexandrorlov.kinopoisk.ui.model

sealed class TypeException {
    data object NoInternet : TypeException()
    data object AllException : TypeException()
}
