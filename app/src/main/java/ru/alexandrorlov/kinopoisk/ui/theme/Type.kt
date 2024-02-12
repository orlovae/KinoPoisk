package ru.alexandrorlov.kinopoisk.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography()

data class TypographyKinopoisk(
    val titleBottomBar: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
    ),
    val titleCard: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    val genreAndYearCard: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        color = Color.Black.copy(alpha = 0.6f),
    ),
    val descriptionTitleDetailMovie: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
    ),
    val descriptionDetailMovie: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    val titleDetailMovie: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        color = Color.White,
    ),
)

val LocalTextStyle = staticCompositionLocalOf { TypographyKinopoisk() }

val MaterialTheme.TypographyKinopoisk
    @Composable
    @ReadOnlyComposable
    get() = LocalTextStyle.current
