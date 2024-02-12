package ru.alexandrorlov.kinopoisk.ui.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel
import ru.alexandrorlov.kinopoisk.ui.state.FailureState
import ru.alexandrorlov.kinopoisk.ui.state.LoadingState

@Composable
internal fun FavoritesScreen(
    viewModel: FavoriteViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.favoriteViewState) {
        FavoriteViewState.Loading -> LoadingState()

        is FavoriteViewState.Data -> FavoriteDataState(
            popularMovieUIList = uiState.favoriteViewState.data.list,
        )

        is FavoriteViewState.Error -> FailureState(
            typeException = uiState.favoriteViewState.error.typeException,
        )
    }
}
