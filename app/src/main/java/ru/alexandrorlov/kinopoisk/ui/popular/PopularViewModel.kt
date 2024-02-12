package ru.alexandrorlov.kinopoisk.ui.popular

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import base.getTypeException
import base.safeLaunch
import common.data.Either
import data.network.api.TopMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.popular.MapToPopularMovieUI
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

internal class PopularViewModel(
    private val repository: TopMovieRepository,
) : BaseViewModel<UIPopularViewState>(
    UIPopularViewState(),
) {
    private val _uiState = MutableStateFlow(UIPopularViewState())
    val uiState = _uiState.asStateFlow()

    private val toMovieUI = MapToPopularMovieUI()

    init {
        viewModelScope.safeLaunch {
            when (val either = repository.getTopMovie()) {
                is Either.Fail -> {
                    val exception = either.value
                    _uiState.update {
                        it.copy(
                            popularViewState = PopularViewState.Error(
                                typeException = exception.getTypeException(),
                            ),
                        )
                    }
                }

                is Either.Success -> {
                    val listMovie = either.value
                    if (listMovie.isNotEmpty()) {
                        _uiState.update {
                            it.copy(
                                popularViewState = PopularViewState.Data(
                                    list = listMovie.map { movie ->
                                        toMovieUI.transform(movie)
                                    },
                                ),
                            )
                        }
                    } else {
                        _uiState.update {
                            it.copy(
                                popularViewState = PopularViewState.Error(
                                    typeException = TypeException.AllException,
                                ),
                            )
                        }
                    }
                }
            }
        }
    }

    fun selectFavoritesMovie(idMovie: Int) {
        _uiState.update {
            val list = it.popularViewState.data.list.map { movieUI ->
                if (movieUI.id == idMovie) {
                    PopularMovieUI(
                        id = movieUI.id,
                        preview = movieUI.preview,
                        title = movieUI.title,
                        genres = movieUI.genres,
                        counties = movieUI.counties,
                        year = movieUI.year,
                        favorite = !movieUI.favorite,
                    )
                } else {
                    movieUI
                }
            }
            it.copy(
                popularViewState = PopularViewState.Data(
                    list = list,
                ),
            )
        }
    }
}
