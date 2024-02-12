package ru.alexandrorlov.kinopoisk.ui.details

import base.UiState
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.details.DetailsMovieUI

sealed class DetailsViewState {
    data object Loading : DetailsViewState()
    data class Data(val detailsMovieUI: DetailsMovieUI) : DetailsViewState()

    val data: Data
        get() = this as Data

    data class Error(val typeException: TypeException) : DetailsViewState()
    val error: Error
        get() = this as Error
}

data class UIDetailViewState(
    val detailViewState: DetailsViewState = DetailsViewState.Loading,
) : UiState
