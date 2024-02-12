package ru.alexandrorlov.kinopoisk.ui.popular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexandrorlov.kinopoisk.ui.state.FailureState
import ru.alexandrorlov.kinopoisk.ui.state.LoadingState
import ru.alexandrorlov.kinopoisk.ui.util.UiConstant.NAV_TO_DETAIL_MOVIE

@Composable
internal fun PopularScreen(
    navController: NavController,
    viewModel: PopularViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.popularViewState) {
        PopularViewState.Loading -> LoadingState()

        is PopularViewState.Data -> PopularDataState(
            popularMovieUIList = uiState.popularViewState.data.list,
            onClick = { idMovieClick ->
                navController.navigate(
                    route = "$NAV_TO_DETAIL_MOVIE/$idMovieClick",
                ) {
                    launchSingleTop = true
                }
            },
            onLongClick = { idMovieLongClick ->
                viewModel.selectFavoritesMovie(idMovie = idMovieLongClick)
            },
        )

        is PopularViewState.Error -> FailureState(
            typeException = uiState.popularViewState.error.typeException,
        )
    }
}
