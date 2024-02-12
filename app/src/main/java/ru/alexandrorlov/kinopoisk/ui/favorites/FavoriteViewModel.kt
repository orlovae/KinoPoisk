package ru.alexandrorlov.kinopoisk.ui.favorites

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import base.safeLaunch
import data.local.api.FavoriteMovieRepository
import data.local.models.MapDbToUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class FavoriteViewModel(
    private val localRepository: FavoriteMovieRepository,
) : BaseViewModel<UIFavoriteViewState>(
    UIFavoriteViewState(),
) {
    private val _uiState = MutableStateFlow(UIFavoriteViewState())
    val uiState = _uiState.asStateFlow()

    private val toMoviePopularMovieUI = MapDbToUi()

    init {
        viewModelScope.safeLaunch {
            val listMovieDb = localRepository.getAllMovie()
            _uiState.update {
                it.copy(
                    favoriteViewState = FavoriteViewState.Data(
                        list = toMoviePopularMovieUI.transform(listMovieDb),
                    ),
                )
            }
        }
    }
}
