package ru.alexandrorlov.kinopoisk.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class ShapesKinopoisk(
    val preview: Shape = RoundedCornerShape(
        size = 5.dp,
    ),
    val cardItem: Shape = RoundedCornerShape(
        size = 15.dp,
    ),
    val button: Shape = RoundedCornerShape(
        size = 100.dp,
    ),
    val dialog: Shape = RoundedCornerShape(
        size = 30.dp,
    ),
)

val LocalShapes = staticCompositionLocalOf { ShapesKinopoisk() }

val MaterialTheme.shapesKinopoisk
    @Composable
    @ReadOnlyComposable
    get() = LocalShapes.current
