package ru.alexandrorlov.kinopoisk.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import base.getTypeException
import base.safeLaunch
import common.data.Either
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import network.api.DetailMovieRepository
import ru.alexandrorlov.kinopoisk.ui.model.details.MapToDetailsMovieUI
import ru.alexandrorlov.kinopoisk.ui.util.UiConstant.MOVIE_ID

internal class DetailsViewModel(
    private val repository: DetailMovieRepository,
    savedState: SavedStateHandle,
) : BaseViewModel<UIDetailViewState>(
    UIDetailViewState(),
) {
    private val _uiState = MutableStateFlow(UIDetailViewState())
    val uiState = _uiState.asStateFlow()

    private val toDetailMovieUI = MapToDetailsMovieUI()

    init {
        val idMovie = savedState.get<Int>(MOVIE_ID)
        if (idMovie != null) { getMovie(idMovie = idMovie) }
    }

    private fun getMovie(idMovie: Int) {
        viewModelScope.safeLaunch {
            when (val either = repository.getDetailMovie(idMovie = idMovie)) {
                is Either.Fail -> {
                    val exception = either.value
                    _uiState.update {
                        it.copy(
                            detailViewState = DetailsViewState.Error(
                                typeException = exception.getTypeException(),
                            ),
                        )
                    }
                }

                is Either.Success -> {
                    val detailsMovieUI = either.value
                    _uiState.update {
                        it.copy(
                            detailViewState = DetailsViewState.Data(
                                detailsMovieUI = toDetailMovieUI.transform(detailsMovieUI),
                            ),
                        )
                    }
                }
            }
        }
    }
}
