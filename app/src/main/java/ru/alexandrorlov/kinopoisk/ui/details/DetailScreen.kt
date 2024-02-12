package ru.alexandrorlov.kinopoisk.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import org.koin.androidx.compose.navigation.koinNavViewModel
import ru.alexandrorlov.kinopoisk.ui.state.FailureState
import ru.alexandrorlov.kinopoisk.ui.state.LoadingState

@Composable
internal fun DetailScreen(
    navController: NavController,
    viewModel: DetailsViewModel = koinNavViewModel(),
    idMovie: Int,
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.detailViewState) {
        DetailsViewState.Loading -> LoadingState()

        is DetailsViewState.Data -> DetailDataState(
            detailsMovieUI = uiState.detailViewState.data.detailsMovieUI,
        )

        is DetailsViewState.Error -> FailureState(
            typeException = uiState.detailViewState.error.typeException,
        )
    }
}
