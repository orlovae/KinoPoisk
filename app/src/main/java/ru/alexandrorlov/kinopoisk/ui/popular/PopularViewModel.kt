package ru.alexandrorlov.kinopoisk.ui.popular

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import base.getTypeException
import base.safeLaunch
import common.data.Either
import data.local.api.FavoriteMovieRepository
import data.local.models.MapUiToDb
import data.network.api.TopMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.popular.MapToPopularMovieUI
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI

internal class PopularViewModel(
    private val networkRepository: TopMovieRepository,
    private val localRepository: FavoriteMovieRepository,
) : BaseViewModel<UIPopularViewState>(
    UIPopularViewState(),
) {
    private val _uiState = MutableStateFlow(UIPopularViewState())
    val uiState = _uiState.asStateFlow()

    private val toMovieUI = MapToPopularMovieUI()
    private val toMovieDb = MapUiToDb()

    init {
        viewModelScope.safeLaunch {
            when (val either = networkRepository.getTopMovie()) {
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
                        genre = movieUI.genre,
                        country = movieUI.country,
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
        saveFavoriteMovieToDatabase(idMovie)
    }

    private fun saveFavoriteMovieToDatabase(idMovie: Int) {
        val favoriteMove = toMovieDb.transform(
            _uiState.value.popularViewState.data.list.first { it.id == idMovie },
        )

        viewModelScope.launch {
            if (favoriteMove.favorite) {
                localRepository.insertMovieDb(favoriteMove)
            } else {
                localRepository.deleteMovieDb(favoriteMove)
            }
        }
    }
}
