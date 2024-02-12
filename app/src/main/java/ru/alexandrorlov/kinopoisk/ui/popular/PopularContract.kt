package ru.alexandrorlov.kinopoisk.ui.popular

import base.UiState
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

sealed class PopularViewState {
    data object Loading : PopularViewState()
    data class Data(val list: List<PopularMovieUI>) : PopularViewState()

    val data: Data
        get() = this as Data

    data class Error(val typeException: TypeException) : PopularViewState()
    val error: Error
        get() = this as Error
}

data class UIPopularViewState(
    val popularViewState: PopularViewState = PopularViewState.Loading,
) : UiState
