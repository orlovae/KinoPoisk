package ru.alexandrorlov.kinopoisk.ui.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.alexandrorlov.kinopoisk.R
import ru.alexandrorlov.kinopoisk.ui.model.popular.PopularMovieUI
import ru.alexandrorlov.kinopoisk.ui.theme.TypographyKinopoisk
import ru.alexandrorlov.kinopoisk.ui.theme.shapesKinopoisk

@Composable
fun PopularDataState(
    popularMovieUIList: List<PopularMovieUI>,
    onClick: (Int) -> Unit,
    onLongClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(
            vertical = dimensionResource(R.dimen.medium_padding),
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.medium_padding),
        ),
    ) {
        items(popularMovieUIList) { movieUI ->
            MovieCard(
                popularMovieUI = movieUI,
                onClick = { onClick(movieUI.id) },
                onLongClick = { onLongClick(movieUI.id) },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MovieCard(
    popularMovieUI: PopularMovieUI,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
) {
    val context = LocalContext.current

    val genreAndYear = popularMovieUI.genre.first() +
        stringResource(R.string.space) +
        stringResource(R.string.opening_parenthesis) +
        popularMovieUI.year +
        stringResource(R.string.closing_parenthesis)

    Card(
        modifier = Modifier
            .height(dimensionResource(R.dimen.height_card))
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onClick() },
                onLongClick = { onLongClick() },
            ),
        shape = MaterialTheme.shapesKinopoisk.cardItem,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.medium_elevation),
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.medium_padding)),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(popularMovieUI.preview)
                    .build(),
                contentScale = ContentScale.Fit,
                contentDescription = popularMovieUI.title,
                modifier = Modifier
                    .width(dimensionResource(R.dimen.width_preview))
                    .fillMaxHeight()
                    .clip(
                        shape = MaterialTheme.shapesKinopoisk.preview,
                    ),
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.medium_padding)),
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        vertical = dimensionResource((R.dimen.medium_padding)),
                    ),
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = popularMovieUI.title,
                        style = MaterialTheme.TypographyKinopoisk.titleCard,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    if (popularMovieUI.favorite) {
                        Icon(
                            painter = painterResource(R.drawable.favorite),
                            contentDescription = "",
                            modifier = Modifier,
                            tint = MaterialTheme.colorScheme.tertiary,
                        )
                    }
                }
                Text(
                    text = genreAndYear,
                    style = MaterialTheme.TypographyKinopoisk.genreAndYearCard,
                )
            }
        }
    }
}
