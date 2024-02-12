package ru.alexandrorlov.kinopoisk.ui.favorites

import base.UiState
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

sealed class FavoriteViewState {
    data object Loading : FavoriteViewState()
    data class Data(val list: List<PopularMovieUI>) : FavoriteViewState()

    val data: Data
        get() = this as Data

    data class Error(val typeException: TypeException) : FavoriteViewState()
    val error: Error
        get() = this as Error
}

data class UIFavoriteViewState(
    val favoriteViewState: FavoriteViewState = FavoriteViewState.Loading,
) : UiState
