package ru.alexandrorlov.kinopoisk.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.alexandrorlov.kinopoisk.R
import ru.alexandrorlov.kinopoisk.ui.model.details.DetailsMovieUI
import ru.alexandrorlov.kinopoisk.ui.theme.TypographyKinopoisk

@Composable
internal fun DetailDataState(
    detailsMovieUI: DetailsMovieUI,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(detailsMovieUI.poster)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.large_padding)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = detailsMovieUI.title.isBlankGetDefault(),
                style = MaterialTheme.TypographyKinopoisk.titleDetailMovie,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.large_padding)),
            )
            Text(
                text = detailsMovieUI.description.isBlankGetDefault(),
                style = MaterialTheme.TypographyKinopoisk.descriptionDetailMovie,
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.medium_padding)),
            )
            MixedRowString(
                title = stringResource(R.string.genres),
                text = detailsMovieUI.genres.isBlankGetDefault(),
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.medium_padding)),
            )
            MixedRowString(
                title = stringResource(R.string.countries),
                text = detailsMovieUI.countries.isBlankGetDefault(),
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.medium_padding)),
            )
            MixedRowString(
                title = stringResource(R.string.year),
                text = detailsMovieUI.year.isBlankGetDefault(),
            )
        }
    }
}

@Composable
private fun MixedRowString(
    title: String,
    text: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            style = MaterialTheme.TypographyKinopoisk.descriptionTitleDetailMovie,
        )
        Text(
            text = text,
            style = MaterialTheme.TypographyKinopoisk.descriptionDetailMovie,
        )
    }
}

@Composable
private fun String.isBlankGetDefault() =
    this.ifBlank {
        stringResource(R.string.value_empty)
    }
