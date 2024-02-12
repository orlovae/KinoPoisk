package ru.alexandrorlov.kinopoisk.ui.state

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.dimensionResource
import base.weightResource
import ru.alexandrorlov.kinopoisk.R

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val infiniteTransition = rememberInfiniteTransition(label = "progressIndicator")

        val angle by infiniteTransition.animateFloat(
            initialValue = weightResource(R.dimen.initial_value_transaction),
            targetValue = weightResource(R.dimen.target_value_transaction),
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 600
                },
            ),
            label = "progressIndicator",
        )

        CircularProgressIndicator(
            progress = weightResource(R.dimen.progress),
            modifier = Modifier
                .size(dimensionResource(R.dimen.size_progress_indicator))
                .rotate(angle),
            color = MaterialTheme.colorScheme.tertiary,
            strokeWidth = dimensionResource(R.dimen.thickness_indicator_loading),
            strokeCap = StrokeCap.Round,
        )
    }
}
