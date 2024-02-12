package ru.alexandrorlov.kinopoisk.ui.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.kinopoisk.R
import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import ru.alexandrorlov.kinopoisk.ui.model.TypeException.AllException
import ru.alexandrorlov.kinopoisk.ui.model.TypeException.NoInternet
import ru.alexandrorlov.kinopoisk.ui.theme.TypographyKinopoisk
import ru.alexandrorlov.kinopoisk.ui.theme.shapesKinopoisk

@Composable
fun FailureState(
    typeException: TypeException,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (typeException) {
            NoInternet -> NoInternetScreen()
            AllException -> AllErrorScreen()
        }
    }
}

@Composable
private fun NoInternetScreen() {
    Image(
        painter = painterResource(R.drawable.no_internet),
        contentDescription = "",
    )
    Text(
        text = stringResource(R.string.no_internet_error),
    )
    BaseButton(
        onClick = { /*TODO*/ },
        textButton = stringResource(R.string.button_text_repeat),
    )
}

@Composable
private fun AllErrorScreen() {
    Text(
        text = stringResource(R.string.all_error),
    )
    BaseButton(
        onClick = { /*TODO*/ },
        textButton = stringResource(R.string.button_text_back),
    )
}

@Composable
private fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textButton: String,
) {
    LargeFloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .wrapContentWidth()
            .height(dimensionResource(R.dimen.height_button)),
        shape = MaterialTheme.shapesKinopoisk.button,
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.primary,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
    ) {
        Text(
            text = textButton,
            maxLines = 1,
            style = MaterialTheme.TypographyKinopoisk.button,
        )
    }
}
